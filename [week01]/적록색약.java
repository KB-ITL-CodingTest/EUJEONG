package KB_ITL_CT;

import java.util.*;
public class 적록색약 {
	static char normal_arr[][]; //정상인 경우의 색깔판
	static char abnormal_arr[][]; //비정상인 경우의 색깔판 
	static boolean visited[][];
	static int[]dx = {-1,0,0,1};
	static int[]dy = {0,1,-1,0};
	static int N;
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		normal_arr = new char[N][N];
		abnormal_arr = new char[N][N];
		visited = new boolean[N][N];
		
		//알파벳 정보 입력받기
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<N;j++) {
				normal_arr[i][j]=s.charAt(j);
				if(s.charAt(j)=='G') {
					abnormal_arr[i][j]='R';
				}else {
					abnormal_arr[i][j]=s.charAt(j);
				}
			}
		}
		
		int normal=0;//정상인 사람이 본 구역의 개수
		int abnormal=0;//적록색약인 사람이 본 구역의 개수
		
		//정상인 경우
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j,normal_arr[i][j],normal_arr);
					normal+=1;
				}
			}
		}
		
		//비정상인 경우
		visited = new boolean[N][N];//초기화
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j, abnormal_arr[i][j],abnormal_arr);
					abnormal+=1;
				}
			}
		}
		
		System.out.print(normal+" "+abnormal);
		sc.close();
	}
	
	public static void dfs(int x, int y,char c, char[][] arr) {
		visited[x][y]=true;
		
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=N||ny<0||ny>=N)continue;
			if(!visited[nx][ny]&&arr[nx][ny]==c) {
				dfs(nx,ny,c,arr);
			}
		}
	}
}
