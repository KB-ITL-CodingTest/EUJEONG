package KB_ITL_CT;
import java.io.*;
import java.util.*;

public class 도시와비트코인 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static boolean arrived = false;
    static int[] dx = {0, 1}, dy = {1, 0}; // 오른쪽, 아래

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (arr[0][0] == 1) {
            dfs(0, 0);
        }

        System.out.println(arrived ? "Yes" : "No");
    }

    public static void dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            arrived = true;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
