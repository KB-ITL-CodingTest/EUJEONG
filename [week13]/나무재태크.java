import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1) 양분 초기화
        int[][] nutrients = new int[n][n];
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nutrients[i], 5);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        // 2) 칸별 나무 리스트 초기화
        LinkedList<Integer>[][] trees = new LinkedList[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                trees[i][j] = new LinkedList<>();

        // 3) 초기 나무 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        // 4) K년 시뮬레이션
        for (int year = 0; year < K; year++) {
            // —— 봄 & 여름 ——  
            int[][] addNutr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (trees[i][j].isEmpty()) continue;
                    LinkedList<Integer> survivors = new LinkedList<>();
                    for (int age : trees[i][j]) {
                        if (nutrients[i][j] >= age) {
                            nutrients[i][j] -= age;
                            survivors.add(age + 1);
                        } else {
                            addNutr[i][j] += age / 2;
                        }
                    }
                    trees[i][j] = survivors;
                }
            }
            // 여름: 죽은 나무 양분으로 추가
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    nutrients[i][j] += addNutr[i][j];

            // —— 가을 번식 ——  
            List<int[]> births = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int age : trees[i][j]) {
                        if (age % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int ni = i + dx[d], nj = j + dy[d];
                                if (ni >= 0 && ni < n && nj >= 0 && nj < n)
                                    births.add(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
            // 번식 나무 나이 1 삽입 (앞쪽에)
            for (int[] b : births)
                trees[b[0]][b[1]].addFirst(1);

            // —— 겨울 추가 양분 ——  
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    nutrients[i][j] += A[i][j];
        }

        // 결과 계산: 살아남은 나무 수
        int result = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result += trees[i][j].size();

        System.out.println(result);
    }
}
