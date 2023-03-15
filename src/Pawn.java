public class Pawn extends Piece {
    private boolean hasMoved;
    
    public Pawn(String color, int rank, int file) 
    {
        super(color, color.equals("White") ? "wP" : "bP", rank, file);
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
        if (getColor().equals("White")) // White pawn
        {
            if (toRank == getRank() - 1) 
            {
                // pawn is moving one square forward
                if (toFile == getFile()) 
                {
                    return true;
                }
                // pawn is moving diagonally to capture a piece
                if ((Math.abs(toFile - getFile()) == 1) && (destPiece != null))
                {
                    return true;
                }
            }
            // check if the pawn is moving two squares forward
            if (getRank() == 6 && toRank == 4 && toFile == getFile()) 
            {
                return true;
            }
        } 
        else // black pawn
        {
            if (toRank == getRank() + 1) 
            {
                // pawn is moving one square forward
                if (toFile == getFile()) 
                {
                    return true;
                }
                // pawn is moving diagonally to capture a piece
                if ((Math.abs(toFile - getFile()) == 1) && (destPiece != null))
                {
                    return true;
                }
            }
            // check if the pawn is moving two squares forward
            if (getRank() == 1 && toRank == 3 && toFile == getFile()) 
            {
                return true;
            }
        }
        return false;
    }
    
}
