package KB_ITL;
import java.io.*;
import java.util.*;
public class w13_눈덩이굴리기 {
    static int n,m;
    static int[]snows;
    static int answer = 0;
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        snows = new int[n+1];
        for(int i=1;i<=n;i++){
            snows[i]=Integer.parseInt(st.nextToken());
        }

        int snow = 1;
        dfs(0,snow,0);
        System.out.println(answer);
    }
    public static void dfs(int index, int snow, int time){
        if(index==n){
            answer = Math.max(answer,snow);
            return;
        }
        if(time==m){
            answer = Math.max(answer,snow);
            return;
        }
        if(index+1<=n)dfs(index+1,snow+snows[index+1],time+1);
        if(index+2<=n)dfs(index+2,(snow/2)+snows[index+2],time+1);
    }
}
