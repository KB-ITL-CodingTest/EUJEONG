package KB_ITL;

import java.util.*;
public class w13_자리배정 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[]dx = {-1,0,1,0}; int[]dy={0,1,0,-1};
        int c = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();

        if(k>c*r){
            System.out.println(0);
            return;
        }
        int[][]arr = new int[r][c];
        boolean[][]visited = new boolean[r][c];

        int cnt = 1, x=r-1,y=0,dir=0;

        while(true){
            if(cnt==k)break;
            visited[x][y]=true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||nx>=r||ny<0||ny>=c||visited[nx][ny]){
                //경계를 벗어나거나 이미 방문했다면
                dir = (dir+1)%4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
            cnt+=1;
        }
        System.out.println((y+1)+" "+(r-x));
        sc.close();
    }
}
