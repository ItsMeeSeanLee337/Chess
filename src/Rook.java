public class Rook extends Piece{
    private boolean hasMoved;
    
    public Rook(String color, int rank, int file) {
        super(color, color == "White" ? "wR" : "bR", rank, file);
        this.hasMoved = false;
    }
}
