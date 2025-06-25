import java.io.*;
import java.util.*;

public class Main {
    // 8방향
    static final int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1) 양분 초기화
        int[][] nutrients = new int[n][n];
        int[][] A = new int[n][n];  // 겨울마다 추가될 양분
        for (int i = 0; i < n; i++) {
            Arrays.fill(nutrients[i], 5);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) 칸별 PriorityQueue 생성
        PriorityQueue<Integer>[][] pq = new PriorityQueue[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq[i][j] = new PriorityQueue<>();  // 오름차순
            }
        }

        // 3) 초기 바이러스 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pq[x][y].offer(age);
        }

        // 4) k년 반복
        for (int year = 0; year < k; year++) {
            // 봄·여름: 살아남은 나무, 그리고 죽은 나무가 남긴 양분 계산
            int[][] deadNutrients = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (pq[i][j].isEmpty()) continue;
                    PriorityQueue<Integer> tmp = new PriorityQueue<>();
                    while (!pq[i][j].isEmpty()) {
                        int age = pq[i][j].poll();
                        if (nutrients[i][j] >= age) {
                            nutrients[i][j] -= age;
                            tmp.offer(age + 1);
                        } else {
                            deadNutrients[i][j] += age / 2;
                        }
                    }
                    pq[i][j] = tmp;
                }
            }
            // 여름: 죽은 나무 양분 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nutrients[i][j] += deadNutrients[i][j];
                }
            }

            // 가을: 번식
            List<int[]> toAdd = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int age : pq[i][j]) {
                        if (age % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int ni = i + dx[d], nj = j + dy[d];
                                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                    toAdd.add(new int[]{ni, nj});
                                }
                            }
                        }
                    }
                }
            }
            // 번식된 나무 삽입
            for (int[] cell : toAdd) {
                pq[cell[0]][cell[1]].offer(1);
            }

            // 겨울: 양분 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nutrients[i][j] += A[i][j];
                }
            }
        }

        // 최종 개수 세기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += pq[i][j].size();
            }
        }
        System.out.println(result);
    }
}
