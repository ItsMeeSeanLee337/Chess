public class Bishop extends Piece{
    private boolean hasMoved;
    
    public Bishop(String color, int rank, int file) {
        super(color, color == "White" ? "wB" : "bB", rank, file);
        this.hasMoved = false;
    }
}
