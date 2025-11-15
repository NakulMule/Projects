import java.util.Scanner;

public class TicTacToe {

    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char currentPlayer = PLAYER_X;
    private static final char[][] board = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        // Main game loop
        for (int turn = 0; turn < 9 && !gameWon; turn++) {
            boolean validMove = false;

            // Prompt for move until a valid one is entered
            while (!validMove) {
                System.out.printf("Player %s, enter your move (row and column: 1 2 or 3 1): ", currentPlayer);
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                // Validate the move
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                    board[row][col] = currentPlayer;
                    validMove = true;
                    printBoard();
                    if (checkWin(row, col)) {
                        System.out.printf("Player %s wins! Congratulations!%n", currentPlayer);
                        gameWon = true;
                    }
                    // Switch players
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
        }

        // Check if the game was a draw
        if (!gameWon) {
            System.out.println("It's a draw! Thanks for playing!");
        }

        scanner.close();
    }

    /**
     * Prints the current state of the board.
     */
    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == EMPTY ? "_" : board[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    /**
     * Checks if the current player has won after placing a piece at (row, col).
     *
     * @param row The row where the last move was made.
     * @param col The column where the last move was made.
     * @return true if the current player has won; false otherwise.
     */
    private static boolean checkWin(int row, int col) {
        // Check row, column, and diagonals
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
                (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}
