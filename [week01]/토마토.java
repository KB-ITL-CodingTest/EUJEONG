package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 토마토 {
	static int N,M, answer=0;
	static int arr[][];
	static int[]dx = {-1,0,0,1};
	static int[]dy = {0,-1,1,0};
	static Queue<tomato> q = new LinkedList<>();
	
	public static class tomato{//토마토 클래스 정의 
		int x;
		int y;
		int day;
		public tomato(int x, int y, int day) {
			this.x=x;
			this.y=y;
			this.day=day;
		}
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());//가로
		N = Integer.parseInt(st.nextToken());//세로
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			//1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토 없음 
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)q.add(new tomato(i,j,0));//토마토인 경우 토마토의 정보를 큐에 저장
			}
		}
		
		int day = 0;
		while(!q.isEmpty()) {
			tomato now = q.poll();
			int cx = now.x;
			int cy = now.y;
			day = now.day;
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0||nx>=N||ny<0||ny>=N)continue;
				if(arr[nx][ny]==0) { //익지 않은 토마토인 경우 익게
					arr[nx][ny]=1;
					q.add(new tomato(nx,ny,day+1));
				}
			}
		}
		
		if(impossible()) {//토마토가 모두 익지는 못하는 상황인 경우
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
	}

	public static boolean impossible() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0)return true; //모두 익지 못하는 상황
			}
		}
		return false; //익지 못한 것은 없음
	}
}
