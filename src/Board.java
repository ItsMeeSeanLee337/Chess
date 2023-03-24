/**
 * Draws/Initiliazes the board and handles movement/boundries
 */
public class Board 
{
    /**
     * Array of pieces
     */
    private Piece[][] board;
    /**
     * Draws the {@link #board board} dimensions and calls {@link #initializeBoard() initializeBoard()}
     */
    public Board() 
    {
        board = new Piece[8][8];
        initializeBoard();
    }
    /**
     * Initializes the board and populates it with pieces
     */
    public void initializeBoard() 
    {
        // Create and place white pieces
        board[0][0] = new Rook("White", 0, 0);
        board[0][1] = new Knight("White", 0, 1);
        board[0][2] = new Bishop("White", 0, 2);
        board[0][3] = new Queen("White", 0, 3);
        board[0][4] = new King("White", 0, 4);
        board[0][5] = new Bishop("White", 0, 5);
        board[0][6] = new Knight("White", 0, 6);
        board[0][7] = new Rook("White", 0, 7);
        for (int i = 0; i < 8; i++) 
        {
            board[1][i] = new Pawn("White", 1, i);
        }

        // Create and place black pieces
        board[7][0] = new Rook("Black", 7, 0);
        board[7][1] = new Knight("Black", 7, 1);
        board[7][2] = new Bishop("Black", 7, 2);
        board[7][3] = new Queen("Black", 7, 3);
        board[7][4] = new King("Black", 7, 4);
        board[7][5] = new Bishop("Black", 7, 5);
        board[7][6] = new Knight("Black", 7, 6);
        board[7][7] = new Rook("Black", 7, 7);
        for (int i = 0; i < 8; i++) 
        {
            board[6][i] = new Pawn("Black", 6, i);
        }
    }
    /**
     * Draws out the visuals for the board
     */
    public void drawBoard() // TODO: drawBoard() does not draw the board in the way shown in the example, easy fix, current iteration is for readablity
    {
        System.out.print(" ");
        for (char file = 'a'; file <= 'h'; file++) 
        {
            System.out.print("  " + file + " ");
        }
        System.out.println();
        
        for (int rank = 8; rank >= 1; rank--) 
        {
            System.out.print(rank);
            for (char file = 'a'; file <= 'h'; file++) 
            {
                if (((rank + file) % 2 == 0) && (board[rank - 1][file - 'a'] == null))
                {
                    System.out.print(" ## ");
                } 
                else 
                {
                    Piece piece = board[rank - 1][file - 'a'];
                    String symbol = piece == null ? "  " : piece.getSymbol();
                    System.out.print(" " + symbol + " ");
                }
            }
            System.out.println(rank);
        }
        
        System.out.print(" ");
        for (char file = 'a'; file <= 'h'; file++) 
        {
            System.out.print("  " + file + " ");
        }
        System.out.println();
    }
    /**
     * Checks if one of the kings has been check'd
     * @param color Black/White
     * @return true if the color's king is in check, false if not
     */
    public boolean isCheck(String color) 
    {
        int kingRank = -1;
        int kingFile = -1;
    
        // Find the location of the king of the given color
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                Piece piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(color)) 
                {
                    kingRank = i;
                    kingFile = j;
                }
            }
        }
    
        // Check if any of the opponent's pieces can attack the king
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                Piece piece = board[i][j];
                if (piece != null && !piece.getColor().equals(color)) 
                {
                    if (piece.isValidMove(kingFile, kingRank, board)) 
                    {
                        return true;
                    }
                }
            }
        }
    
        return false;
    }
    /**
     * Checks if pieces can attack a given square
     * @param rank Row 
     * @param file Column
     * @param color Black/White
     * @return true if a piece can attack with a valid move
     */
    public boolean isSquareAttacked(int rank, int file, String color) 
    {
        // Check if any of the opponent's pieces can attack the given square
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                Piece piece = board[i][j];
                if (piece != null && !piece.getColor().equals(color)) 
                {
                    if (piece.isValidMove(file, rank, board)) 
                    {
                        return true;
                    }
                }
            }
        }
    
        // No pieces can attack the given square
        return false;
    }
    
    /**
     * Determines that a castling move is valid
     * @param move Move Data
     * @param color Black/White
     * @return True/False if it is/is not a valid move
     */
    public boolean isValidCastlingMove(String move, String color) 
    {
        // Parse the move string and get the king's starting and ending positions
        int fromFile = move.charAt(0) - 'a';
        int fromRank = 8 - (move.charAt(1) - '0');
        int toFile = move.charAt(3) - 'a';
        int toRank = 8 - (move.charAt(4) - '0');
        
        // Check that the move is a castling move
        if (Math.abs(fromFile - toFile) != 2 || fromRank != toRank) 
        {
            return false;
        }
        
        // Check that the king and rook have not moved
        Piece king = board[fromRank][fromFile];
        Piece rook = board[fromRank][toFile == 6 ? 7 : 0];
        if (king == null || rook == null || king.hasMoved() || rook.hasMoved()) 
        {
            return false;
        }
        
        // Check that there are no pieces between the king and rook
        int rookFile = toFile == 6 ? 7 : 0;
        int direction = toFile > fromFile ? 1 : -1;
        for (int i = fromFile + direction; i != rookFile; i += direction) 
        {
            if (board[fromRank][i] != null) 
            {
                return false;
            }
        }
        
        // Check that the king is not in check
        if (isCheck(color)) 
        {
            return false;
        }
        
        // Check that the squares the king passes over are not attacked
        int passFile = fromFile + direction;
        int[] passRanks = {fromRank, fromRank, fromRank};
        int[] attackRanks = {fromRank - 1, fromRank, fromRank + 1};
        for (int i = 0; i < 3; i++) 
        {
            if (isSquareAttacked(passFile, passRanks[i], color)) 
            {
                return false;
            }
            if (board[attackRanks[i]][passFile] != null) 
            {
                return false;
            }
        }
        
        return true;
    }
    /**
     * Makes moves and updates the board
     * @param move Move Data
     * @param turn Whos turn it is
     * @return True or False if the move is valid
     */
    public boolean makeMove(String move, Boolean turn) 
    {
        // Parse the move string and update the board
        int fromFile = move.charAt(0) - 'a';
        int fromRank = Character.getNumericValue(move.charAt(1)) - 1;
        int toFile = move.charAt(3) - 'a';
        int toRank = Character.getNumericValue(move.charAt(4)) - 1;
        
        Piece piece = board[fromRank][fromFile];
        if (piece == null) // Moving from an empty space
        {
            System.out.println("Illegal move, try again");
            return false;
        }
        else if (turn == true) // White move, meaning you can only move white pieces
        {
            if (piece.isValidMove(toRank, toFile, board) && piece.color == "White")
            {
                board[fromRank][fromFile] = null;
                board[toRank][toFile] = piece;
                piece.setRank(toRank);
                piece.setFile(toFile);
                return true;
            }
            else
            {
                System.out.println("Illegal move, try again");
                return false;
            }
        }
        else // Black move, meaning you can only move black pieces
        {
            if (piece.isValidMove(toRank, toFile, board) && piece.color == "Black")
            {
                board[fromRank][fromFile] = null;
                board[toRank][toFile] = piece;
                piece.setRank(toRank);
                piece.setFile(toFile);
                return true;
            }
            else
            {
                System.out.println("Illegal move, try again");
                return false;
            }
        }
        
    }
}
