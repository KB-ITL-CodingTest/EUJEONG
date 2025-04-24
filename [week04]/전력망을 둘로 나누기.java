import java.util.*;
class Solution {
    static int [][]arr;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        //인접 리스트보다는 인접 행렬이 데이터를 다루기에 더 용이함
        arr = new int[n+1][n+1];
        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }
        
        for(int i=0;i<wires.length;i++){
            //제거할 송전탑 a와 b
            int a = wires[i][0];
            int b = wires[i][1];
            arr[a][b]=0;//두 송전탑의 연결 끊어버리기
            arr[b][a]=0;
            
            answer = Math.min(answer,bfs(n,a));
            
            arr[a][b]=1;
            arr[b][a]=1; //연결 상태 복귀
        }
        return answer;
    }
    public static int bfs(int n, int start){
        int group1 = 1;
        boolean[]visited = new boolean[n+1];
        visited[start]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    group1++;
                }
            }
        }
        int group2 = n - group1;
        return Math.abs(group1-group2);
        
    }
}
