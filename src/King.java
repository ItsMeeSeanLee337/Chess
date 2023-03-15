public class King extends Piece{
    private boolean hasMoved;
    
    public King(String color, int rank, int file) {
        super(color, color.equals("White") ? "wK" : "bK", rank, file);
        this.hasMoved = false;
    }
    
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }

    public void setFile(int toFile) 
    {
        super.setFile(toFile);
        hasMoved = true;
    }

    public boolean hasMoved() 
    {
        return hasMoved;
    }

    public boolean isValidMove(int toRank, int toFile, Board board) 
    {
        // check if the move is within the board
        if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) 
        {
            return false;
        }

        Piece destPiece = board.getPiece(toRank, toFile);
        
        // check if the destination square is occupied by a friendly piece
        if (destPiece != null && destPiece.getColor().equals(getColor())) 
        {
            return false;
        }
        
        int rankDiff = Math.abs(toRank - getRank());
        int fileDiff = Math.abs(toFile - getFile());
        
        // check if the move is a valid king move, we check for castling in the Board class
        if ((rankDiff == 1 && fileDiff == 0) || (rankDiff == 0 && fileDiff == 1) || (rankDiff == 1 && fileDiff == 1)) 
        {
            return true;
        }
        
        return false;
    }

}
