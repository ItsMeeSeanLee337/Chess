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
            if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
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
                if(chessBoard.makeMove(input, turn) == true)
                {
                    chessBoard.drawBoard();
                    turn = !turn; // Flip the turn  
                }
                else // In the case that the move is not valid and returns false
                {
                    chessBoard.drawBoard();
                    continue; // Continue without flipping the turn
                }
                if (input.contains("draw?")) // In the case that a player offers a draw:
                {
                    if (turn == true)
                    {
                        System.out.print("White's move: ");
                    }
                    else
                    {
                        System.out.print("Black's move: ");
                    }
                    input = scanner.nextLine(); // If the other player sumbits "draw" as their move, the game ends
                    if (input.contains("draw"))
                    {
                        return;
                    }
                    else // Otherwise the game should continue as normal
                    {
                        // In the very specific case that the other player does not accept the draw, and inputs an illegal move, then decides to accept the draw after inputting the illegal move we get an index out of bounds error
                        if(chessBoard.makeMove(input, turn) == true)
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
    }
}

/*
 * TODO: Bugs list
 * 1. Need to check if castling works
 * 2. Need to implement empassment
 * 3. Need to implement promotion
 * 4. Need to check if check is identified properly
 * 5. Need to check if checkmate is prpoerly identified and properly ends the game
 */