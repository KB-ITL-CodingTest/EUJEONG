import java.io.*;
import java.util.*;
public class Main {
	public static int N,M,x,y;
	public static int [][]map;
	public static int [][]dice= {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		
		int k=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		map[x][y]=0;//주사위를 놓은 칸에 쓰여있는 숫자는 0이다.
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<k;i++) {
			int order=Integer.parseInt(st.nextToken());
			move(order);
		}
		
		
	}
	
	public static void move(int order) {
		int temp,nx=x,ny=y;
		switch(order) {
			case 1://동쪽
				nx=x;
				ny=y+1;
				if((nx<0||nx>=N)||(ny<0||ny>=M))return;
				temp=dice[0][1];
				dice[0][1]=dice[1][0];
				dice[1][0]=dice[2][1];
				dice[2][1]=dice[1][2];
				dice[1][2]=temp;
				break;
			case 2://서쪽
				nx=x;
				ny=y-1;
				if((nx<0||nx>=N)||(ny<0||ny>=M))return;
				temp=dice[0][1];
				dice[0][1]=dice[1][2];
				dice[1][2]=dice[2][1];
				dice[2][1]=dice[1][0];
				dice[1][0]=temp;
				break;
			case 3://북쪽
				nx=x-1;
				ny=y;
				if((nx<0||nx>=N)||(ny<0||ny>=M))return;
				temp=dice[3][1];
				dice[3][1]=dice[2][1];
				dice[2][1]=dice[1][1];
				dice[1][1]=dice[0][1];
				dice[0][1]=temp;
				break;
			case 4://남쪽
				nx=x+1;
				ny=y;
				if((nx<0||nx>=N)||(ny<0||ny>=M))return;
				temp=dice[0][1];
				dice[0][1]=dice[1][1];
				dice[1][1]=dice[2][1];
				dice[2][1]=dice[3][1];
				dice[3][1]=temp;
				break;
			default:
				break;
		}
		x=nx;
		y=ny;
		if(map[nx][ny]==0)map[nx][ny]=dice[2][1];
		else {
			dice[2][1]=map[nx][ny];
			map[nx][ny]=0;
		}
		System.out.println(dice[0][1]);
	}
}
