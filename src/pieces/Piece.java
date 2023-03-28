package pieces;

/**
 * Defines a abstract piece
 */
public abstract class Piece 
{  
    /**
     * Black/White
     */
    public String color;
    /**
     * Visuals
     */
    public String symbol;
    /**
     * Row
     */
    public int rank;
    /**
     * Column
     */
    public int file;
    /**
     * Constructor
     * @param color {@link #color color}
     * @param symbol {@link #symbol symbol}
     * @param rank {@link #rank rank}
     * @param file {@link #file file}
     */
    public Piece(String color, String symbol, int rank, int file) 
    {
        this.color = color;
        this.symbol = symbol;
        this.rank = rank;
        this.file = file;
    }
    /**
     * Sets the Rank of the Piece
     * @param toRank Destination {@link #rank Row}
     */
    public void setRank(int toRank) 
    {
        this.rank = toRank;
    }
    /**
     * Sets the File of the Piece
     * @param toFile Destination {@link #rank Row}
     */
    public void setFile(int toFile) 
    {
        this.file = toFile;
    }
    /**
     * Returns the symbol of the Piece
     * @return Piece {@link #symbol symbol}
     */
    public String getSymbol()
    {
        return symbol;
    }
    /**
     * Returns the color of the piece
     * @return Piece {@link #color color}
     */
    public String getColor() 
    {
        return color;
    }
    /**
     * Returns the Rank of the piece
     * @return Piece {@link #rank rank}
     */
    public int getRank() 
    {
        return rank;
    }
    /**
     * Returns the File of the piece
     * @return File {@link #file File}
     */    
    public int getFile() 
    {
        return file;
    }
    /**
     * Determines if move is valid
     * @param toRank Destination {@link #rank rank}
     * @param toFile Destination {@link #file File}
     * @param board Current Board
     * @return True or False
     */
    public abstract boolean isValidMove(int toRank, int toFile,  Piece[][] board);
    /**
     * Determines if the piece has moved
     * @return True or False
     */
    public abstract boolean hasMoved();
}