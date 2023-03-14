public abstract class Piece {
    public enum Color {
        WHITE,
        BLACK
    }
    
    private String color;
    private String symbol;
    private int rank;
    private int file;
    
    public Piece(String color, String symbol, int rank, int file) {
        this.color = color;
        this.symbol = symbol;
        this.rank = rank;
        this.file = file;
    }

    public void setRank(int toRank) {
        this.rank = toRank;
    }
    
    public void setFile(int toFile) {
        this.file = toFile;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
    
}