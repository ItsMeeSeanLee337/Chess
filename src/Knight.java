public class Knight extends Piece{
    private boolean hasMoved;
    
    public Knight(String color, int rank, int file) {
        super(color, color.equals("White") ? "wN" : "bN", rank, file);
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

        Piece destPiece = board.getPiece(toRank, toFile); // check if the destination square is empty
        int rankDiff = Math.abs(toRank - getRank());
        int fileDiff = Math.abs(toFile - getFile());

        // check if the move is valid for a knight
        if ((rankDiff == 2 && fileDiff == 1) || (rankDiff == 1 && fileDiff == 2))
        {
            // check if the destination square is occupied by a piece of the same color
            if (destPiece != null && destPiece.getColor().equals(getColor()))
            {
                return false;
            }
            return true;
        }
        return false;
    }

}
