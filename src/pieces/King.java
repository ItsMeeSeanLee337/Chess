package pieces;

/**
 * Defines a King piece
 */
public class King extends Piece
{
    /**
     * Determines if a King has moved
     */  
    private boolean hasMoved;
    /**
     * Constructor
     * @param color Black/White
     * @param rank Row
     * @param file Column
     */     
    public King(String color, int rank, int file) 
    {
        super(color, color.equals("White") ? "wK" : "bK", rank, file);
        this.hasMoved = false;
    }
    /**
     * Sets King's Row and sets {@link #hasMoved hasMoved} to true
     */     
    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }
    /**
     * Sets King's Column and sets {@link #hasMoved hasMoved} to true
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
     * Defines the valid moves for a King
     */
    @Override
    public boolean isValidMove(int toRank, int toFile, Piece[][] board) 
    {
        // check if the move is within the board
        if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) 
        {
            return false;
        }

        Piece destPiece = board[toRank][toFile];
        
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
