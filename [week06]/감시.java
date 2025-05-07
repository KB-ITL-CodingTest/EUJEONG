package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 감시 {
	static int N,M,answer=Integer.MAX_VALUE;//N은 세로, M은 가로
	static int [][]arr;
	
	public static int[] dx = {-1, 1, 0, 0};  // 상하좌우
	public static int[] dy = {0, 0, -1, 1};

	public static int[][][] direct = {
	    {{0}},                             // 0번 CCTV 없음
	    {{0}, {1}, {2}, {3}},              // 1번 CCTV: 4방향 중 1개
	    {{2, 3}, {0, 1}},                  // 2번 CCTV: 좌우 / 상하
	    {{0, 3}, {1, 3}, {1, 2}, {0, 2}},  // 3번 CCTV: ㄴ자 형태 4방향
	    {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}, // 4번 CCTV 세 방향
	    {{0, 1, 2, 3}}                     // 5번 CCTV
	};
	
	public static class cctv{
		int x;
		int y;
		int num;
		public cctv(int x, int y, int num) {
			this.x=x;
			this.y=y;
			this.num=num;
		}
	}
	public static ArrayList<cctv>cctvs;//cctv들 저장해 놓을 리스트
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctvs = new ArrayList<>();
		
		for(int i=0;i<N;i++) {//정보 저장하기
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				
				arr[i][j]=Integer.parseInt(st.nextToken());
				//cctv일 경우 위치, cctv의 종류를 리스트에 저장해놓기
				if(arr[i][j]>0&&arr[i][j]<6)cctvs.add(new cctv(i,j,arr[i][j]));
			}
		}
		
		
		dfs(0,cctvs.size(),arr); //dfs탐색
		System.out.println(answer);
	}
	
	public static void dfs(int depth, int size,int[][]arr) {
		if(depth==size) {
			//백트래킹, 모든 cctv에 대해 탐색을 다 했다면 answer를 갱신
			int safeArea = getSafeArea(arr);//사각지대의 크기
			answer = Math.min(answer, safeArea);
			return;
		}
		//현재 탐색하는 cctv
		int type = cctvs.get(depth).num;
		int x = cctvs.get(depth).x;
		int y = cctvs.get(depth).y;
		
		for(int i=0;i<direct[type].length;i++) {//현재 cctv의 i번 case에 대해
			int[][]copy = new int[N][M];
			for(int j=0;j<N;j++) {
				copy[j]=arr[j].clone();
			}
			for(int j=0;j<direct[type][i].length;j++) {//i번 case 내의 가능한 방향들 모두 진행
				int nx = x + dx[direct[type][i][j]];
				int ny = y + dy[direct[type][i][j]];
				
				while(true) {
					if(nx<0 || nx>=N || ny<0 || ny>=M)break; //범위 벗어나면 그만
					if(arr[nx][ny]==6) break; //벽을 만나면 그만
					if(copy[nx][ny]==0)copy[nx][ny]=-1;//감시 가능하면 -1로 
					
					nx += dx[direct[type][i][j]];
					ny += dy[direct[type][i][j]];
				}
			}
			
			dfs(depth+1, size,copy);
		}
	}
	
	public static int getSafeArea(int[][]map) {//사각지대의 넓이 구하기
		int area = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0)area+=1;
			}
		}
		return area;
	}
}
