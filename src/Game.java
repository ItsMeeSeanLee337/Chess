import java.util.Scanner;

public class Game 
{
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

/*
 * TODO: Bugs list
 * 1. Input f8 a3 gives index out of bounds error, this is for moving a black bishop from it's starting position to a3, need to check if this bug applies to all bishops and/or pieces
 * 2. Moving rooks does not check if there are any pieces in between its starting position and its final position, move should not be allowed if there are pieces between these two positions
 * 3. Need to check if castling works
 * 4. Need to implement empassment
 * 5. Need to implement promotion
 * 6. Need to check if check is identified properly
 * 7. Need to test draw feature
 * 8. Need to check if checkmate is prpoerly identified and properly ends the game
 * 9. Input c8 h3 gives index out of bounds error, this is for moving a black bishop from it's starting position to h3, I suspect this bug is for bishops specifically
 * 10. Other opponent can move pieces that he does not own
 * 11. Rook is able to pass through pieces, need to check if this is a bug with rook specifically or applies to other pieces
 * 12. If a pawn is moving two spaces forward, does not check if the first space in front of it is already occupied, if so the move must not be allowed
 * 13. Pawn does not properly take pieces that it is diagonal to
 * 14. Input c8 g4 gives index out of bounds error, this is for moving a black bishop from it's starting position to g4
 * 15. When a pawn is in its starting position, it is not allowed to only move one square forward, this should be allowed
 * 16. Queen is able to pass through pieces if moving horizontally or vertically, not diagonally, byproduct of using rooks methods in the queen file
 * 17. Queen cannot make the move d6 a3, should be possible if queen is on square d6, possibly a byproduct of using bishop methods in the queen file
 */