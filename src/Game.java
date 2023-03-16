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

    public static boolean draw(String input, Boolean turn, Scanner scanner, Board chessBoard) // Draw functionality works sometimes, needs testing for all cases
    {
        if (input.contains("draw?")) // In the case that a player offers a draw:
        {
            chessBoard.drawBoard();
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
        chessBoard.drawBoard();
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
            if (draw(input, turn, scanner, chessBoard)) // In the case that a player offers a draw:
            {
                return; // End the game if the input is "draw", otherwise continue the game as normal
            }
            else if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
            {
                return; // Ends the game if a player resigns
            }
            else // In the case that the input does not contain "draw?" or "resign", we obtain the moves to process
            {
                // Bottom 4 variables are for debugging
                int fromFile = input.charAt(0) - 'a';
                int fromRank = Character.getNumericValue(input.charAt(1)) - 1;
                int toFile = input.charAt(3) - 'a';
                int toRank = Character.getNumericValue(input.charAt(4)) - 1;
                if(chessBoard.makeMove(input) == true)
                {
                    chessBoard.drawBoard();
                    turn = !turn; // Flip the turn  
                }
                else // In the case that the move is not valid and returns false
                {
                    chessBoard.drawBoard();
                    continue; // Continue without flipping the turn
                }
            }
        }
    }
}
