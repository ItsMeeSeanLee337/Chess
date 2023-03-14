public class Knight extends Piece{
    private boolean hasMoved;
    
    public Knight(String color, int rank, int file) {
        super(color, color == "White" ? "wN" : "bN", rank, file);
        this.hasMoved = false;
    }
}
