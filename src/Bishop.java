public class Bishop extends Piece{
    private boolean hasMoved;
    
    public Bishop(String color, int rank, int file) {
        super(color, color.equals("White") ? "wB" : "bB", rank, file);
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
        // check if the move is within the board
        if (toRank < 0 || toRank > 7 || toFile < 0 || toFile > 7) 
        {
            return false;
        }

        Piece destPiece = board.getPiece(toRank, toFile); // check if the destination square is empty
        if (destPiece != null && destPiece.getColor().equals(getColor())) // destination square contains a piece of the same color
        {
            return false;
        }

        int rankDiff = Math.abs(toRank - getRank());
        int fileDiff = Math.abs(toFile - getFile());

        if (rankDiff != fileDiff) // the move is not diagonal
        {
            return false;
        }

        int rankDir = rankDiff > 0 ? 1 : -1;
        int fileDir = rankDiff > 0 ? 1 : -1;

        int curRank = getRank() + rankDir;
        int curFile = getFile() + fileDir;

        while (curRank != toRank && curFile != toFile) // check all squares between the starting and ending squares
        {
            if (board.getPiece(curRank, curFile) != null) // there is a piece on the way
            {
                return false;
            }

            curRank += rankDir;
            curFile += fileDir;
        }

        return true;
    }

}
