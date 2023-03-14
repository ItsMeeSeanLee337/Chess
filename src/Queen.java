public class Queen extends Piece{
    private boolean hasMoved;
    
    public Queen(String color, int rank, int file) {
        super(color, color.equals("White") ? "wQ" : "bQ", rank, file);
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

    public boolean isValidMove(int toRank, int toFile, Board board) {
    // check if the move is within the board
    if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) {
        return false;
    }

    Piece destPiece = board.getPiece(toRank, toFile); // check if the destination square is empty
    if (destPiece != null && destPiece.getColor().equals(getColor())) {
        return false;
    }

    // check if the move is along a straight line (like a rook)
    if (getRank() == toRank || getFile() == toFile) {
        Rook rook = new Rook(getColor(), getRank(), getFile());
        return rook.isValidMove(toRank, toFile, board);
    }

    // check if the move is along a diagonal line (like a bishop)
    if (Math.abs(toRank - getRank()) == Math.abs(toFile - getFile())) {
        Bishop bishop = new Bishop(getColor(), getRank(), getFile());
        return bishop.isValidMove(toRank, toFile, board);
    }

    // if neither of the above, the move is not valid
    return false;
}
    
}
