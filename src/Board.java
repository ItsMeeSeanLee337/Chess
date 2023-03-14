public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    public void initializeBoard() {
        // Create and place white pieces
        board[0][0] = new Rook(Color.WHITE, 0, 0);
        board[0][1] = new Knight(Color.WHITE, 0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE, 0, 4);
        board[0][5] = new Bishop(Color.WHITE, 0, 5);
        board[0][6] = new Knight(Color.WHITE, 0, 6);
        board[0][7] = new Rook(Color.WHITE, 0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        // Create and place black pieces
        board[7][0] = new Rook(Color.BLACK, 7, 0);
        board[7][1] = new Knight(Color.BLACK, 7, 1);
        board[7][2] = new Bishop(Color.BLACK, 7, 2);
        board[7][3] = new Queen(Color.BLACK, 7, 3);
        board[7][4] = new King(Color.BLACK, 7, 4);
        board[7][5] = new Bishop(Color.BLACK, 7, 5);
        board[7][6] = new Knight(Color.BLACK, 7, 6);
        board[7][7] = new Rook(Color.BLACK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, 6, i);
        }
    }

    public void displayBoard() {
        System.out.print(" ");
        for (char file = 'a'; file <= 'h'; file++) {
            System.out.print("  " + file + " ");
        }
        System.out.println();
        
        for (int rank = 8; rank >= 1; rank--) {
            System.out.print(rank);
            for (char file = 'a'; file <= 'h'; file++) {
                if ((rank + file) % 2 == 0) {
                    System.out.print(" ## ");
                } else {
                    Piece piece = board[rank - 1][file - 'a'];
                    String symbol = piece == null ? "  " : piece.getSymbol();
                    System.out.print(" " + symbol + " ");
                }
            }
            System.out.println(rank);
        }
        
        System.out.print(" ");
        for (char file = 'a'; file <= 'h'; file++) {
            System.out.print("  " + file + " ");
        }
        System.out.println();
    }

    public void makeMove(String move) {
        // Parse the move string and update the board
        int fromFile = move.charAt(0) - 'a';
        int fromRank = 8 - (move.charAt(1) - '0');
        int toFile = move.charAt(3) - 'a';
        int toRank = 8 - (move.charAt(4) - '0');

        Piece piece = board[fromRank][fromFile];
        board[fromRank][fromFile] = null;
        board[toRank][toFile] = piece;
        piece.setRank(toRank);
        piece.setFile(toFile);
    }
}
