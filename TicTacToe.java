import java.util.Scanner;

public class TicTacToe{
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';  // Player X starts first
        int turns = 0;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter a position (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                makeMove(move, currentPlayer);
                turns++;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (turns == 9) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Print the Tic-Tac-Toe board
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
        System.out.println();
    }

    // Check if a move is valid (i.e., not already taken)
    public static boolean isValidMove(int move) {
        switch (move) {
            case 1: return board[0][0] == ' ';
            case 2: return board[0][1] == ' ';
            case 3: return board[0][2] == ' ';
            case 4: return board[1][0] == ' ';
            case 5: return board[1][1] == ' ';
            case 6: return board[1][2] == ' ';
            case 7: return board[2][0] == ' ';
            case 8: return board[2][1] == ' ';
            case 9: return board[2][2] == ' ';
            default: return false;
        }
    }

    // Make a move on the board
    public static void makeMove(int move, char player) {
        switch (move) {
            case 1: board[0][0] = player; break;
            case 2: board[0][1] = player; break;
            case 3: board[0][2] = player; break;
            case 4: board[1][0] = player; break;
            case 5: board[1][1] = player; break;
            case 6: board[1][2] = player; break;
            case 7: board[2][0] = player; break;
            case 8: board[2][1] = player; break;
            case 9: board[2][2] = player; break;
        }
    }

    // Check if the current player has won
    public static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||  // Row 1
               (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||  // Row 2
               (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||  // Row 3
               (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||  // Column 1
               (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||  // Column 2
               (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||  // Column 3
               (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||  // Diagonal 1
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);    // Diagonal 2
    }
}
