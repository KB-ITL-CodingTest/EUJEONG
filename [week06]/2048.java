import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(answer);
    }

    public static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            answer = Math.max(answer, getMax(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = deepCopy(board);
            move(dir, nextBoard);
            dfs(depth + 1, nextBoard);
        }
    }

    public static void move(int dir, int[][] board) {
        boolean[][] merged = new boolean[N][N];

        switch (dir) {
            case 0: // 동쪽 (오른쪽)
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (board[i][j] == 0) continue;
                        int col = j;
                        while (col + 1 < N && board[i][col + 1] == 0) {
                            board[i][col + 1] = board[i][col];
                            board[i][col] = 0;
                            col++;
                        }
                        if (col + 1 < N && board[i][col] == board[i][col + 1] && !merged[i][col + 1]) {
                            board[i][col + 1] *= 2;
                            board[i][col] = 0;
                            merged[i][col + 1] = true;
                        }
                    }
                }
                break;

            case 1: // 서쪽 (왼쪽)
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (board[i][j] == 0) continue;
                        int col = j;
                        while (col - 1 >= 0 && board[i][col - 1] == 0) {
                            board[i][col - 1] = board[i][col];
                            board[i][col] = 0;
                            col--;
                        }
                        if (col - 1 >= 0 && board[i][col] == board[i][col - 1] && !merged[i][col - 1]) {
                            board[i][col - 1] *= 2;
                            board[i][col] = 0;
                            merged[i][col - 1] = true;
                        }
                    }
                }
                break;

            case 2: // 북쪽 (위쪽)
                for (int j = 0; j < N; j++) {
                    for (int i = 1; i < N; i++) {
                        if (board[i][j] == 0) continue;
                        int row = i;
                        while (row - 1 >= 0 && board[row - 1][j] == 0) {
                            board[row - 1][j] = board[row][j];
                            board[row][j] = 0;
                            row--;
                        }
                        if (row - 1 >= 0 && board[row][j] == board[row - 1][j] && !merged[row - 1][j]) {
                            board[row - 1][j] *= 2;
                            board[row][j] = 0;
                            merged[row - 1][j] = true;
                        }
                    }
                }
                break;

            case 3: // 남쪽 (아래쪽)
                for (int j = 0; j < N; j++) {
                    for (int i = N - 2; i >= 0; i--) {
                        if (board[i][j] == 0) continue;
                        int row = i;
                        while (row + 1 < N && board[row + 1][j] == 0) {
                            board[row + 1][j] = board[row][j];
                            board[row][j] = 0;
                            row++;
                        }
                        if (row + 1 < N && board[row][j] == board[row + 1][j] && !merged[row + 1][j]) {
                            board[row + 1][j] *= 2;
                            board[row][j] = 0;
                            merged[row + 1][j] = true;
                        }
                    }
                }
                break;
        }
    }

    public static int getMax(int[][] board) {
        int max = 0;
        for (int[] row : board) {
            for (int num : row) {
                max = Math.max(max, num);
            }
        }
        return max;
    }

    public static int[][] deepCopy(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }
}
