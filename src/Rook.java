public class Rook extends Piece{
    private boolean hasMoved;
    
    public Rook(String color, int rank, int file) {
        super(color, color.equals("White") ? "wR" : "bR", rank, file);
        this.hasMoved = false;
    }

    @Override
    public void setRank(int toRank) 
    {
        super.setRank(toRank);
        hasMoved = true;
    }

    @Override
    public void setFile(int toFile) 
    {
        super.setFile(toFile);
        hasMoved = true;
    }

    @Override
    public boolean hasMoved() 
    {
        return hasMoved;
    }

    @Override
    public boolean isValidMove(int toRank, int toFile, Piece[][] board) 
    {
        // check if the move is within the board
        if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) 
        {
            return false;
        }

        Piece destPiece = board[toRank][toFile]; // check if the destination square is empty

        // check if the rook is moving vertically
        if (toFile == getFile()) 
        {
            // check if there are any pieces blocking the rook's path
            int start = Math.min(getRank(), toRank);
            int end = Math.max(getRank(), toRank);
            for (int i = start + 1; i < end; i++) 
            {
                Piece piece = board[toRank][toFile];
                if (piece != null) 
                {
                    return false;
                }
            }
            // check if the destination square is empty or contains an opponent's piece
            if (destPiece == null || !destPiece.getColor().equals(getColor())) 
            {
                return true;
            }
        }
        // check if the rook is moving horizontally
        else if (toRank == getRank()) 
        {
            // check if there are any pieces blocking the rook's path
            int start = Math.min(getFile(), toFile);
            int end = Math.max(getFile(), toFile);
            for (int i = start + 1; i < end; i++) 
            {
                Piece piece = board[toRank][toFile];
                if (piece != null) 
                {
                    return false;
                }
            }
            // check if the destination square is empty or contains an opponent's piece
            if (destPiece == null || !destPiece.getColor().equals(getColor())) 
            {
                return true;
            }
        }
        return false;
    }

}
