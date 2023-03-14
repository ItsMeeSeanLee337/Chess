public abstract class Piece 
{  
    public String color;
    public String symbol;
    public int rank;
    public int file;
    
    public Piece(String color, String symbol, int rank, int file) 
    {
        this.color = color;
        this.symbol = symbol;
        this.rank = rank;
        this.file = file;
    }

    public void setRank(int toRank) 
    {
        this.rank = toRank;
    }
    
    public void setFile(int toFile) 
    {
        this.file = toFile;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public String getColor() 
    {
        return color;
    }

    public int getRank() 
    {
        return rank;
    }

    public int getFile() 
    {
        return file;
    }
    
}