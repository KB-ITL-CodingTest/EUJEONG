import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String line = bf.readLine();
        //각 사람마다 본인의 위치에서 가장 멀리 떨어진 곳의 햄버거를 먹어야 함
        int[] arr = new int[N];
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='H')arr[i]=0;//햄버거
            else arr[i]=1;//사람
        }
        int answer = 0;
        boolean[]visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(arr[i]==1){//사람인 경우
                int start = i - K;
                if(start<0)start=0;
                

                while(start<=i+K){
                    
                    if(!visited[start]&&arr[start]==0){
                        visited[start]=true;
                        answer+=1;
                        break;
                    }
                    
                    start+=1;
                    if(start==N)break;
                }
            }
        }
        System.out.println(answer);
    }
}
