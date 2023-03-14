public class Queen extends Piece{
    private boolean hasMoved;
    
    public Queen(String color, int rank, int file) {
        super(color, color == "White" ? "wQ" : "bQ", rank, file);
        this.hasMoved = false;
    }
}
