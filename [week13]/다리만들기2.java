import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, id;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        id  = new int[N][M];
        
        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        // 섬들마다 번호 매기기
        int islandCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
   기
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (id[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        makeBridge(i, j, d, edges);
                    }
                }
            }
        }

        // 크루스칼 + 유니온-파인드
        Collections.sort(edges);//다리 길이 오름차순으로 정렬
        int[] parent = new int[islandCnt + 1];
        for (int i = 1; i <= islandCnt; i++) parent[i] = i;

        // 최소 신장 트리 만들기
        int used = 0, totalLen = 0;
        for (Edge e : edges) {
            if (find(parent, e.u) != find(parent, e.v)) {
                union(parent, e.u, e.v);
                totalLen += e.len;
                if (++used == islandCnt - 1) break;
            }
        }

        System.out.println(used == islandCnt - 1 ? totalLen : -1);
    }

    static void bfs(int r, int c, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        id[r][c] = num;
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dx[d], nc = cur[1] + dy[d];
                if (nr<0||nr>=N||nc<0||nc>=M) continue;
                if (!visited[nr][nc] && map[nr][nc]==1) {
                    visited[nr][nc] = true;
                    id[nr][nc] = num;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static void makeBridge(int r, int c, int d, List<Edge> edges) {
        int len = 0, cr = r, cc = c;
        int src = id[r][c];
        while (true) {
            cr += dx[d]; cc += dy[d];
            if (cr<0||cr>=N||cc<0||cc>=M || id[cr][cc]==src) return;
            if (id[cr][cc] > 0) {
                if (len >= 2) {
                    edges.add(new Edge(src, id[cr][cc], len));
                }
                return;
            }
            len++;
        }
    }

    static int find(int[] p, int x) {
        if (p[x] == x) return x;
        return p[x] = find(p, p[x]);
    }

    static void union(int[] p, int a, int b) {
        a = find(p, a); b = find(p, b);
        if (a != b) p[b] = a;
    }

    static class Edge implements Comparable<Edge> {
        int u, v, len;
        Edge(int u, int v, int len) {
            this.u=u; this.v=v; this.len=len;
        }
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
}
