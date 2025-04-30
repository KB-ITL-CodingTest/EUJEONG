import java.io.*;
import java.util.*;

public class Main {
   static char[][]arr;
   static int n,m;
   static boolean[][]visited;
   
   
   static int ww,bb;
   
   
   static int[]dx= {-1,0,0,1};
   static int[]dy= {0,1,-1,0};
   
   public static void W_dfs(int i,int j) {
      visited[i][j]=true;
      
      
      for(int k=0;k<4;k++) {
         int new_x=i+dx[k];
         int new_y=j+dy[k];
         
         if(new_x<0||new_x>=m||new_y<0||new_y>=n)continue;
         if(arr[new_x][new_y]=='W'&&!visited[new_x][new_y]) {
            ww+=1;
            W_dfs(new_x,new_y);
         }
      }
   }
   
   public static void B_dfs(int i,int j) {
      visited[i][j]=true;
      
      for(int k=0;k<4;k++) {
         int new_x=i+dx[k];
         int new_y=j+dy[k];
         
         if(new_x<0||new_x>=m||new_y<0||new_y>=n)continue;
         if(arr[new_x][new_y]=='B'&&!visited[new_x][new_y]) {
            bb+=1;
            B_dfs(new_x,new_y);
         }
      }
   }
   public static void main(String[]args) throws IOException{
      BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(bf.readLine());
      
      n=Integer.parseInt(st.nextToken());
      m=Integer.parseInt(st.nextToken());
      arr=new char[m][n];
      visited=new boolean[m][n];
      
   
      for (int i = 0; i < m; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
      
      int W_answer=0;
      int B_answer=0;
      
      for(int i=0;i<m;i++) {
         for(int j=0;j<n;j++) {

            if(!visited[i][j]) {
               
               if(arr[i][j]=='W') {
                  ww=1;
                  W_dfs(i,j);
                  W_answer+=(ww*ww);
                  
               }
               else {
                  bb=1;
                  B_dfs(i,j);
                  B_answer+=(bb*bb);
               }
               
            }
            
         }
      }
      
      System.out.print(W_answer+" "+B_answer);
   }
}
