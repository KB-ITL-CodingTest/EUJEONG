import java.util.*;
import java.io.*;
public class Main {
    public static int n,m;
    public static int[][]arr;
    public static boolean[][]visited;
    public static int max = Integer.MIN_VALUE;
    public static int []dx = {-1,0,0,1};
    public static int []dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=true;
                dfs(i,j,1,arr[i][j]);
                visited[i][j]=false;
            }
        }
        System.out.println(max);
    }
    public static void dfs(int x, int y,int count,int sum){
        if(count==4){
            if(sum>max)max = sum;
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if((nx<0||nx>=n)||(ny<0||ny>=m))continue;
            if(!visited[nx][ny]){
                //fuck you 모양일 경우
                if(count==2){
                    visited[nx][ny]=true;
                    dfs(x,y,count+1,sum+arr[nx][ny]);
                    visited[nx][ny]=false;
                }
                visited[nx][ny]=true;
                dfs(nx,ny,count+1,sum+arr[nx][ny]);
                visited[nx][ny]=false;
            }
        }
    }
}
