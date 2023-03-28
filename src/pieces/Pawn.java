package pieces;

/**
 * Defines a Pawn piece
 */
public class Pawn extends Piece {
    /**
     * Determines if a Pawn has moved
     */   
    private boolean hasMoved;
    /**
     * Constructor
     * @param color Black/White
     * @param rank Row
     * @param file Column
     */     
    public Pawn(String color, int rank, int file) 
    {
        super(color, color.equals("White") ? "wp" : "bp", rank, file);
        this.hasMoved = false;
    }
    /**
     * Sets Pawn's Row and sets {@link #hasMoved hasMoved} to true
     */ 
    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }
    /**
     * Sets Pawn's Column and sets {@link #hasMoved hasMoved} to true
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
     * Defines the valid moves for a Pawn
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
        if (getColor().equals("White")) // White pawn
        {
            if (toRank == getRank() + 1) 
            {
                // pawn is moving one square forward
                if (toFile == getFile() && destPiece == null) 
                {
                    return true;
                }
                // pawn is moving diagonally to capture a piece
                if ((Math.abs(toFile - getFile()) == 1) && (destPiece != null))
                {
                    return true;
                }
            }
            // check if the pawn is moving two squares forward or one squre forward from starting position
            if (getRank() == 1 && toRank == 3 && board[2][toFile] == null && toFile == getFile()) 
            {
                return true;
            }
            else if (getRank() == 1 && toRank == 2 && destPiece == null && toFile == getFile()) 
            {
                return true;
            }
        } 
        else // black pawn
        {
            if (toRank == getRank() - 1) 
            {
                // pawn is moving one square forward
                if (toFile == getFile() && destPiece == null) 
                {
                    return true;
                }
                // pawn is moving diagonally to capture a piece
                if ((Math.abs(toFile - getFile()) == 1) && (destPiece != null))
                {
                    return true;
                }
            }
            // check if the pawn is moving two squares forward or one squre forward from starting position
            if (getRank() == 6 && toRank == 4 && board[5][toFile] == null && toFile == getFile()) 
            {
                return true;
            }
            else if (getRank() == 6 && toRank == 5 && destPiece == null && toFile == getFile()) 
            {
                return true;
            }
        }
        return false;
    }
    
}
