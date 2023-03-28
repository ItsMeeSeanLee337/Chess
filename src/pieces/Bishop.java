package pieces;

/**
 * Defines a Bishop piece
 */
public class Bishop extends Piece{
    /**
     * Determines if a Bishop has moved
     */ 
    private boolean hasMoved;
    /**
     * Constructor
     * @param color Black/White
     * @param rank Row
     * @param file Column
     */     
    public Bishop(String color, int rank, int file) {
        super(color, color.equals("White") ? "wB" : "bB", rank, file);
        this.hasMoved = false;
    }
    /**
     * Sets Bishop's Row and sets {@link #hasMoved hasMoved} to true
     */    
    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }
    /**
     * Sets Bishop's Column and sets {@link #hasMoved hasMoved} to true
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
     * Defines the valid moves for a Bishop
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
        if (destPiece != null && destPiece.getColor().equals(getColor())) // destination square contains a piece of the same color
        {
            return false;
        }

        int rankDiff = Math.abs(toRank - getRank());
        int fileDiff = Math.abs(toFile - getFile());

        if (rankDiff != fileDiff) // the move is not diagonal
        {
            return false;
        }

        int rankDir;
        int fileDir;
        if (getRank() - toRank > 0) // If the getRank - toRank > 0, we are moving downwards
        {
            rankDir = -1;
        }
        else
        {
            rankDir = 1; // Otherwise, we are moving upwards
        }
        if (getFile() - toFile > 0) // If the getFile - toFile > 0, we are moving downwards
        {
            fileDir = -1;
        }
        else
        {
            fileDir = 1;
        }

        int curRank = getRank() + rankDir;
        int curFile = getFile() + fileDir;

        while (curRank != toRank && curFile != toFile) // check all squares between the starting and ending squares
        {
            if (board[curRank][curFile] != null) // there is a piece on the way
            {
                return false;
            }

            curRank += rankDir;
            curFile += fileDir;
        }

        return true;
    }

}
