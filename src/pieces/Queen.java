package pieces;

/**
 * Defines a Queen piece
 */
public class Queen extends Piece
{
    /**
     * Determines if a Queen has moved
     */    
    private boolean hasMoved;
    /**
     * Constructor
     * @param color Black/White
     * @param rank Row
     * @param file Column
     */    
    public Queen(String color, int rank, int file) 
    {
        super(color, color.equals("White") ? "wQ" : "bQ", rank, file);
        this.hasMoved = false;
    }
    /**
     * Sets Queen's Row and sets {@link #hasMoved hasMoved} to true
     */    
    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }
    /**
     * Sets Queen's Column and sets {@link #hasMoved hasMoved} to true
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
     * Defines the valid moves for a Queen
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
        if (destPiece != null && destPiece.getColor().equals(getColor())) 
        {
            return false;
        }

        // check if the move is along a straight line (like a rook)
        if (getRank() == toRank || getFile() == toFile) 
        {
            Rook rook = new Rook(getColor(), getRank(), getFile());
            return rook.isValidMove(toRank, toFile, board);
        }

        // check if the move is along a diagonal line (like a bishop)
        if (Math.abs(toRank - getRank()) == Math.abs(toFile - getFile())) 
        {
            Bishop bishop = new Bishop(getColor(), getRank(), getFile());
            return bishop.isValidMove(toRank, toFile, board);
        }

        // if neither of the above, the move is not valid
        return false;
    }
}
