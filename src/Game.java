import java.util.Scanner;

public class Game {
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
    public static boolean resign(String input, Boolean turn) // TODO: resign the game for valid input by user
    {
        if (input.contains("resign")) // In the case that a player submits resign as their move, the other player automatically wins
        {
            if (turn == true)
            {
                System.out.print("Black wins");
            }
            else
            {
                System.out.print("White wins");
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean draw(String input, Boolean turn, Scanner scanner) // Must test draw functionality
    {
        if (input.contains("draw?")) // In the case that a player offers a draw:
        {
            if (turn == true)
            {
                System.out.print("Black's move: ");
            }
            else
            {
                System.out.print("White's move: ");
            }
            input = scanner.nextLine(); // If the other player sumbits "draw" as their move, the game ends
            if (input.contains("draw"))
            {
                return true;
            }
            else // Otherwise the game should continue as normal
            {
                return false;
                // TODO: Implement functionality for when opponent does not accept draw
            }
        }
        else
        {
            return false;
        }
    }

    public static void checkMate() // TODO: Validate if checkmate has been achieved, react appropriately
    {

    } 

    public static void main(String[] args) {
        Board chessBoard = new Board();
        chessBoard.displayBoard();
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
            String input = scanner.nextLine(); // read the user input as a single string, 
            if (draw(input, turn, scanner)) // In the case that a player offers a draw:
            {
                return; // End the game if the input is "draw", otherwise continue the game as normal
            }
            else if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
            {
                return; // Ends the game if a player resigns
            }
            else // In the case that the input does not contain "draw?" or "resign", we obtain the moves to process
            {
                
                char fromCol = input.charAt(0); // Gets the fromCol character
                int fromRow = Character.getNumericValue(input.charAt(1)); // Gets the fromRow integer
                char toCol = input.charAt(3); // Gets the toCol character
                int toRow =  Character.getNumericValue(input.charAt(4)); // Gets the toRow integer
                turn = !turn; // Flip the turn  
            }
        }
    }
}
