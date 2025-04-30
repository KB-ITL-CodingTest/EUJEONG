import java.util.*;
class Solution {
    static int n,m,sum=0;
    static int[][]arr;
    static boolean[][]visited;
    static int dx[]={-1,0,0,1};
    static int dy[]={0,1,-1,0};
    public int[] solution(String[] maps) {
        boolean noisland = true;
        List<Integer> list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='X')arr[i][j]=0;
                else {
                    arr[i][j]=maps[i].charAt(j)-'0';
                    noisland = false;
                }
            }
        }
        if(noisland)return new int[]{-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]>0&&!visited[i][j]){
                    sum = arr[i][j];
                    dfs(i,j);
                    list.add(sum);
                    sum=0;
                }
            }
        }
        int[]answer = new int[list.size()];
        for(int i=0;i<answer.length;i++)answer[i]=list.get(i);
        Arrays.sort(answer);
        return answer;
    }
    public static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if((nx>=0&&nx<n)&&(ny>=0&&ny<m)){
                if(!visited[nx][ny]&&arr[nx][ny]>0){
                    sum+=arr[nx][ny];
                    dfs(nx,ny);
                }
            }
        }
    }
}
