public class Chess {
    private static final String[][] board = {
        {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "BR", "8"},
        {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP", "7"},
        {"  ", "##", "  ", "##", "  ", "##", "  ", "##", "6"},
        {"##", "  ", "##", "  ", "##", "  ", "##", "  ", "5"},
        {"  ", "##", "  ", "##", "  ", "##", "  ", "##", "4"},
        {"##", "  ", "##", "  ", "##", "  ", "##", "  ", "3"},
        {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP", "2"},
        {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR", "1"},
        {" a", " b", " c", " d", " e", " f", " g", " h"},
    };

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
    }
}
