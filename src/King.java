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

        Piece destPiece = board.getPiece(toRank, toFile); // check if the destination square is empty
        if (getColor().equals("White")) // White pawn
        {
                
        }
        else // Black pawn
        {

        }
    }
}
