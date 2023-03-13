import java.util.Scanner;

public class Chess {
    private static final String[][] board = {
        {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "BR"},
        {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
        {"  ", "##", "  ", "##", "  ", "##", "  ", "##"},
        {"##", "  ", "##", "  ", "##", "  ", "##", "  "},
        {"  ", "##", "  ", "##", "  ", "##", "  ", "##"},
        {"##", "  ", "##", "  ", "##", "  ", "##", "  "},
        {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
        {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"}
    };

    public static void displayBoard(String[][] board) 
    {
        // TODO: When displaying the board and a piece has moved out of position revealing a black square underneath, draw the board appropriately
        // has nothing to do with the displayBoard method, something to keep in mind when writing the other move methods
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println(" a  b  c  d  e  f  g  h");
    }
    
    public static void movePawn() // TODO: Check if pawn's move is valid, move accordingly
    {

    }
    public static void moveRook() // TODO: Check if rook's move is valid, move accordingly
    {

    }
    public static void moveBishop() // TODO: Check if bishop's move is valid, move accordingly
    {

    }
    public static void moveQueen() // TODO: Check if queen's move is valid, move accordingly
    {

    }
    public static void moveKing() // TODO: Check if king's move is valid, move accordingly
    {

    }
    public static void moveKnight() // TODO: Check if knight's move is valid, move accordingly
    {

    }
    public static void castle() // TODO: Check if king is attempting a castling move, castle accordingly if valid
    {

    }
    public static void enpassment() // TODO: Check if enpassment is valid
    {

    }
    public static void promotion() // TODO: Check if a pawn has reached the end of the board, appropriately promote to queen
    {

    }
    public static void check() // TODO: Validate if "check" has been achieved
    {

    }
    public static void checkMate() // TODO: Validate if checkmate has been achieved, react appropriately
    public static void main(String[] args) {
        displayBoard(board);
        Scanner scanner = new Scanner(System.in);
        // White = true, Black = false
        boolean turn = true;
        boolean endgame = false;
        while (endgame != true)
        {
            if (turn == true)
            {
                System.out.print("White's move: ");
            }
            else
            {
                System.out.print("Black's move: ");
            }
            // TODO: Check if the move made is an illegal move, react appropriately
            String input = scanner.nextLine(); // read the user input as a single string, TODO: If the input is "Resign", have the opposite player win
            String[] parts = input.split(" "); // split the input string into two parts using space as the delimiter
            char fromCol = input.charAt(0); // Gets the fromCol character
            int fromRow = Character.getNumericValue(input.charAt(1)); // Gets the fromRow integer
            char toCol = input.charAt(3); // Gets the toCol character
            int toRow =  Character.getNumericValue(input.charAt(4)); // Gets the toRow integer
            // TODO: Must implement functionality for when the input is followed by "draw?" 
            turn = !turn;
        }
    }
}
