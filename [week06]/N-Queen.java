package KB_ITL_CT;
import java.util.*;
public class NQueen {
	static int N;
    static int answer = 0;
    static boolean[] cols;     // 열
    static boolean[] diag1;    // ↘ 대각선 (row + col)
    static boolean[] diag2;    // ↙ 대각선 (row - col + N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cols = new boolean[N];
        diag1 = new boolean[2 * N]; 
        diag2 = new boolean[2 * N];

        dfs(0);
        System.out.println(answer);
        sc.close();
    }

    static void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (cols[col] || diag1[row + col] || diag2[row - col + N]) continue;

            cols[col] = diag1[row + col] = diag2[row - col + N] = true;
            dfs(row + 1);
            cols[col] = diag1[row + col] = diag2[row - col + N] = false;
        }
    }
}
