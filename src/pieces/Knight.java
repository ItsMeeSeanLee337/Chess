package pieces;

/**
 * Defines a Knight piece
 */
public class Knight extends Piece{
    /**
     * Determines if a Knight has moved
     */  
    private boolean hasMoved;
    /**
     * Constructor
     * @param color Black/White
     * @param rank Row
     * @param file Column
     */     
    public Knight(String color, int rank, int file) {
        super(color, color.equals("White") ? "wN" : "bN", rank, file);
        this.hasMoved = false;
    }
    /**
     * Sets Knight's Row and sets {@link #hasMoved hasMoved} to true
     */     
    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }
    /**
     * Sets Knight's Column and sets {@link #hasMoved hasMoved} to true
     */
    @Override
    public void setFile(int toFile) 
    {
        super.setFile(toFile);
        hasMoved = true;
    }
    /**
     * Returns {@link #hasMoved hasMoved}
     */
    @Override
    public boolean hasMoved() 
    {
        return hasMoved;
    }
    /**
     * Defines the valid moves for a Knight
     */
    @Override
    public boolean isValidMove(int toRank, int toFile, Piece[][] board) 
    {
        // check if the move is within the board
        if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) 
        {
            return false;
        }

        Piece destPiece = board[toRank][toFile]; // check if the destination square is empty
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
