import java.util.Scanner;
/**
 * Defines rules like Resigning, Check/Checkmate, Empassment, and Promotion
 */
public class Game 
{
    /**
     * Handles for when a player decides to resign
     * @param input Input from console
     * @param turn True during the players turn
     * @return True for resigning, false if not
     */
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
    /**
     * To handle checkmates
     * @param Piece[][] chessboard
     * @param color Black/White
     * @return true if a king of a certain color is in checkmate
     */
    public static boolean checkMate(Piece[][] board, boolean turn) // TODO: Validate if checkmate has been achieved, react appropriately
    {
        String color;
        if (turn = true)
        {
            color = "White";
        }
        else
        {
            color = "Black";
        }
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
    
        // Check if any of the opponent's pieces can attack the king at his current position, or any of the other 8 positions he can move to
        // Current iteration does not account for when there aren't 8 positions the king can move to, such as if the king is in a corner
        /*
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        // position 1: i - 1, j - 1
        if (Board.isSquareAttacked((kingRank - 1), (kingFile - 1), color, board))
        {
            return true;
        }
        // position 2: i - 1, j
        if (Board.isSquareAttacked((kingRank - 1), (kingFile), color, board))
        {
            return true;
        }
        // position 3: i - 1, j + 1
        if (Board.isSquareAttacked((kingRank - 1), (kingFile + 1), color, board))
        {
            return true;
        }
        // position 4: i, j - 1
        if (Board.isSquareAttacked((kingRank), (kingFile - 1), color, board))
        {
            return true;
        }
        // position 5: i, j
        if (Board.isSquareAttacked((kingRank), (kingFile), color, board))
        {
            return true;
        }
        // position 6: i, j + 1
        if (Board.isSquareAttacked((kingRank), (kingFile + 1), color, board))
        {
            return true;
        }
        // position 7: i + 1, j - 1
        if (Board.isSquareAttacked((kingRank + 1), (kingFile - 1), color, board))
        {
            return true;
        }
        // position 8: i + 1, j
        if (Board.isSquareAttacked((kingRank + 1), (kingFile), color, board))
        {
            return true;
        }
        // position 9: i + 1, j + 1
        if (Board.isSquareAttacked((kingRank + 1), (kingFile + 1), color, board))
        {
            return true;
        }
        else
        {
            return false;
        }
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
                if (chessBoard.isCheck("White") == true)
                {
                    System.out.println("check");
                }
                System.out.print("White's move: ");
            }
            else
            {
                if (chessBoard.isCheck("White") == true)
                {
                    System.out.println("check");
                }
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
                    if (checkMate(chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
                    {
                        if (turn == true)
                        {
                            System.out.println("Checkmate");
                            System.out.println("Black wins");
                            return;
                        }
                        else
                        {
                            System.out.println("Checkmate");
                            System.out.println("White wins");
                            return;
                        }
                    }
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
                            if (checkMate(chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
                            {
                                if (turn == true)
                                {
                                    System.out.println("Checkmate");
                                    System.out.println("Black wins");
                                    return;
                                }
                                else
                                {
                                    System.out.println("Checkmate");
                                    System.out.println("White wins");
                                    return;
                                }
                            }
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