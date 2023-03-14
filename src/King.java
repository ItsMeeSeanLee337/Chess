public class King extends Piece{
    private boolean hasMoved;
    
    public King(String color, int rank, int file) {
        super(color, color == "White" ? "wK" : "bK", rank, file);
        this.hasMoved = false;
    }
}
