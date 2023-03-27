import java.util.Scanner;
/**
 * Defines rules like Resigning, Check/Checkmate, Enpassant, and Promotion
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
     * @param chessBoard Board
     * @param board piece array
     * @param color Black/White
     * @return true if a king of a certain color is in checkmate
     */
    public static boolean checkMate(Board chessBoard, Piece[][] board, boolean turn) // TODO: Validate if checkmate has been achieved, react appropriately
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
    
        if (chessBoard.isCheck("color") == false) // If the king is not in check, then checkmate is not possible
        {
            return false;
        }
        else
        {
            Piece king = board[kingRank][kingFile];
            for (int row = -1; row <= 1; row++) 
            {
                for (int col = -1; col <= 1; col++) 
                {
                    if (row == 0 && col == 0) 
                    {
                        continue;
                    }

                    int destRow = kingRank + row;
                    int destCol = kingFile + col;
                    // Check if the king can move to this position
                    Piece tempPiece = board[destRow][destCol];
                    if (king.isValidMove(destRow, destCol,board)) 
                    {
                        // Move the king to this position and check if it is still in check
                        board[destRow][destCol] = king;
                        king.setRank(destRow);
                        king.setFile(destCol);

                        boolean stillCheck = chessBoard.isCheck("White");

                        // Undo the move
                        board[destRow][destCol] = tempPiece;
                        king.setRank(kingRank);
                        king.setFile(kingFile);

                        // If the king can move out of check, then it is not checkmate
                        if (stillCheck == false) 
                        {
                            return false;
                        }
                    }
                }
            }
            // If the king cannot move out of check, then it is checkmate
            return true;
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
                if (chessBoard.isCheck("Black") == true)
                {
                    System.out.println("check");
                }
                System.out.print("Black's move: ");
            }
            String input = scanner.nextLine(); // read the user input as a single string, 
            if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
            {
                return; // Ends the game if a player resigns
            }
            else // In the case that the input does not contain "resign", we obtain the moves to process
            {
                // Bottom 4 variables are for debugging
                int fromFile = input.charAt(0) - 'a';
                int fromRank = Character.getNumericValue(input.charAt(1)) - 1;
                int toFile = input.charAt(3) - 'a';
                int toRank = Character.getNumericValue(input.charAt(4)) - 1;
                if(chessBoard.makeMove(input, turn) == true)
                {
                    if (turn == true && fromRank == 1 && toRank == 3 && chessBoard.board[toRank][toFile] instanceof Pawn) // Checking conditions for Enpassant, white pawn
                    {
                        int oldFile = toFile;
                        chessBoard.drawBoard(); // If the conditions for Enpassant are satisfied, we prompt the other player for a move and check to see if they execute Enpassant
                        turn = !turn; // Flip the turn  
                        System.out.print("Black's move: ");
                        input = scanner.nextLine();
                        fromFile = input.charAt(0) - 'a';
                        fromRank = Character.getNumericValue(input.charAt(1)) - 1;
                        toFile = input.charAt(3) - 'a';
                        toRank = Character.getNumericValue(input.charAt(4)) - 1;
                        if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
                        {
                            return; // Ends the game if a player resigns
                        }
                        if(chessBoard.makeMove(input, turn) == true) // Execute the move as normal otherwise
                        {
                            if (toFile == oldFile && fromRank == 3 && toRank == 2 && chessBoard.board[toRank][toFile] instanceof Pawn) // If the conditions for Enpassant are valid, remove the white pawn that advanced two squares
                            {
                                chessBoard.board[3][fromFile] = null;
                            }
                            if (checkMate(chessBoard, chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
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
                        }
                    }
                    else if (turn == false && fromRank == 6 && toRank == 4 && chessBoard.board[toRank][toFile] instanceof Pawn) // Checking conditions for Enpassant, black pawn
                    {
                        int oldFile = toFile;
                        chessBoard.drawBoard(); // If the conditions for Enpassant are satisfied, we prompt the other player for a move and check to see if they execute Enpassant
                        turn = !turn; // Flip the turn  
                        System.out.print("White's move: ");
                        input = scanner.nextLine();
                        fromFile = input.charAt(0) - 'a';
                        fromRank = Character.getNumericValue(input.charAt(1)) - 1;
                        toFile = input.charAt(3) - 'a';
                        toRank = Character.getNumericValue(input.charAt(4)) - 1;
                        if (resign(input, turn)) // In the case that a player submits resign as their move, the other player automatically wins
                        {
                            return; // Ends the game if a player resigns
                        }
                        if(chessBoard.makeMove(input, turn) == true) // Execute the move as normal otherwise
                        {
                            if (toFile == oldFile && fromRank == 4 && toRank == 5 && chessBoard.board[toRank][toFile] instanceof Pawn) // If the conditions for Enpassant are valid, remove the black pawn that advanced two squares
                            {
                                chessBoard.board[5][fromFile] = null;
                            }
                            if (checkMate(chessBoard, chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
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
                        }
                    }
                    if (checkMate(chessBoard, chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
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
                        if (chessBoard.isCheck("White") == true)
                        {
                            System.out.println("check");
                        }
                        System.out.print("White's move: ");
                    }
                    else
                    {
                        if (chessBoard.isCheck("Black") == true)
                        {
                            System.out.println("check");
                        }
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
                            if (checkMate(chessBoard, chessBoard.board, turn)) // If the move made causes checkmate, end the game accordingly
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
 * 1. Need to test castling
 * 2. Need to test Enpassant
 * 3. Need to test promotion
 * 4. Check works, needs more testing
 * 5. Need to test checkMate method
 */