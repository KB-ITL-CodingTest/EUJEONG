import java.io.*;
import java.util.*;

public class Main {
	public static int[][]fish=new int[4][4]; //물고기 저장된
	public static int[][]direct=new int[4][4]; //저장된 물고기의 방향들 
	public static int []dx={0,-1,-1,0,1,1,1,0,-1}; //각 방향에 따라 이동하게 될 경로
	public static int []dy= {0,0,-1,-1,-1,0,1,1,1}; 
	
	public static int maxScore=0;
	
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<4;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<4;j++) {
				fish[i][j]=Integer.parseInt(st.nextToken());//물고기의 위치
				direct[i][j]=Integer.parseInt(st.nextToken());//방향	
			}	
		}
		
		//상어가 (0,0)에서 시작
		int initialFish=fish[0][0];//처음 물고기 값
		int initialDirection=direct[0][0];//처음 물고기의 방향
		fish[0][0]=0;//먹힌 물고기는 사라진다
		
		dfs(0,0,initialDirection,initialFish);
		
		System.out.println(maxScore);
	}
	
	public static void dfs(int sx, int sy, int sDir, int score) {
		maxScore=Math.max(maxScore, score); //최대인 점수로 구하기
		
		//현재 배열 복사해서 이용하기
		int [][]backupFish=new int[4][4];
		int [][]backupDirect=new int[4][4];
		copyState(fish,backupFish,direct,backupDirect);
		
		//물고기 이동
		moveFish(sx,sy); //sx와 sy는 상어의 위치임, 전달하는 이유는 물고기가 상어가 있는 곳은 이동할 수 없기 때문에
		
		//상어의 이동, 상어는 같은 방향으로 최대 *3만큼 이동할 수 있음
		for(int step=1;step<4;step++) {
			int nx=sx+dx[sDir]*step;
			int ny=sy+dy[sDir]*step;
			
			if(InRange(nx,ny)&&fish[nx][ny]!=0) {
				int eatenFish=fish[nx][ny];
				int newDirection=direct[nx][ny];
				fish[nx][ny]=0;
				
				dfs(nx,ny,newDirection,score+eatenFish);
				
				//최적이 아니면 다시 원래대로 돌려놓기
				fish[nx][ny]=eatenFish;
			}
		}
		copyState(backupFish,fish,backupDirect,direct);
	}
	
	public static void moveFish(int sx,int sy) {
		for(int i=1;i<=16;i++) {
			boolean moved=false;
			for(int x=0;x<4&&!moved;x++) {
				for(int y=0; y<4 && !moved; y++) {
					if(fish[x][y]==i) {
						int d=direct[x][y];
						for(int j=0; j<8; j++) {
							int nx= x+dx[d];
							int ny= y+dy[d];
							
							if(InRange(nx,ny)&&!(nx==sx&&ny==sy)) {
								swap(x,y,nx,ny);
								moved=true;
								break;
							}
							d=(d%8)+1;
							direct[x][y]=d;
						}
					}
				}
			}
		}
	}
	
	public static boolean InRange(int x,int y) {
		if((x>=0&&x<=3)&&(y>=0&&y<=3))return true;
		else return false;
	}
	
	public static void swap(int cx,int cy,int nx,int ny) {
		int temp=fish[cx][cy];
		fish[cx][cy]=fish[nx][ny];
		fish[nx][ny]=temp;
		
		int temp2=direct[cx][cy];
		direct[cx][cy]=direct[nx][ny];
		direct[nx][ny]=temp2;

	}
	
	public static void copyState(int[][]fromFish, int[][]toFish,int[][]fromDirect,int[][]toDirect) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				toFish[i][j]=fromFish[i][j];
				toDirect[i][j]=fromDirect[i][j];
			}
		}
	}
	
}
