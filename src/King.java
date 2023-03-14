public class King extends Piece{
    private boolean hasMoved;
    
    public King(String color, int rank, int file) {
        super(color, color == "White" ? "wK" : "bK", rank, file);
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

    }
}
