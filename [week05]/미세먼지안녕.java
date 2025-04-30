import java.io.*;
import java.util.*;
public class Main {
	public static int[][]board;
	public static boolean[][]visited;
	public static int R,C,T,vux,vdx,start=0;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy= {0,1,0,-1};
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		visited = new boolean [R][C];
		int [][]copy=new int[R][C];
		
		for(int i=0;i<R;i++) {//값 초기화하기
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<C;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				
				if(board[i][j]>0)visited[i][j]=true;
				if(board[i][j]==-1&&start==0) {
					vux=i;//공기청정기의 위치					
					start=1;
					vdx=i+1;
				}
			}
		}
	
		int time=0;
		while(true) {
			if(time==T) {
				//T초가 되었을 때 종료
				count();//남아있는 미세먼지의 양 출력
				break;
			}
			
			//배열 복사하기
			copy(board,copy);
			//step1. 미세먼지의 확산
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(visited[i][j]) {
						//네 방향 순회해서 가능한 경우 찾기
						int spread=0; //확산한 방향의 개수
						for(int k=0;k<4;k++) {
							int nx=i+dx[k];
							int ny=j+dy[k];
							if((nx>=0&&nx<R)&&(ny>=0&&ny<C)) {
								if(board[nx][ny]!=-1) {
									//확산 가능하다면
									spread+=1;
									copy[nx][ny]+=(int)(board[i][j]/5);//확산시키기
								}
								
							}
						}
						copy[i][j]-=spread*((int)(board[i][j]/5));
					}
				}
			}

			copy(copy,board);
		
			//step2. 공기청정기의 작동
			//윗쪽 공기청정기
			int temp1=board[vux][C-1];
			int temp2=board[0][C-1];
			int temp3=board[0][0];
			copy[vux][1]=0;
			copy[vdx][1]=0;
			for(int i=2;i<C;i++) {
				if(board[vux][i-1]>=0)copy[vux][i]=board[vux][i-1];
			}
			for(int i=vux-2;i>=0;i--) {
				if(board[i+1][C-1]>=0)copy[i][C-1]=board[i+1][C-1];
			}
			for(int i=C-3;i>=0;i--) {
				if(i<0)break;
				if(board[0][i+1]>=0)copy[0][i]=board[0][i+1];
			}
			for(int i=2;i<vux;i++) {
				if(board[i-1][0]>=0)copy[i][0]=board[i-1][0];
			}
			copy[vux-1][C-1]=temp1;
			copy[0][C-2]=temp2;
			copy[1][0]=temp3;
			
			//아랫쪽 공기청정기
			int temp4=board[vdx][C-1];
			int temp5=board[R-1][C-1];
			int temp6=board[R-1][0];
			
			for(int i=2;i<C;i++) {
				if(board[vdx][i-1]>=0)copy[vdx][i]=board[vdx][i-1];
			}
			for(int i=vdx+2;i<R;i++) {
				if(board[i-1][C-1]>=0)copy[i][C-1]=board[i-1][C-1];
			}
			for(int i=C-3;i>=0;i--) {
				if(board[R-1][i+1]>=0)copy[R-1][i]=board[R-1][i+1];
			}
			for(int i=R-3;i>vdx;i--) {
				if(board[i+1][0]>=0)copy[i][0]=board[i+1][0];
			}
			copy[vdx+1][C-1]=temp4;
			copy[R-1][C-2]=temp5;
			copy[R-2][0]=temp6;
			
			copy[vux][0]=-1;
			copy[vdx][0]=-1;
			
			copy(copy,board);
			
			
			//미세먼지 있는 곳들을 visited 방문 처리하기
			visited=new boolean[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(board[i][j]>0)visited[i][j]=true;
				}
			}
			time+=1;
		}
	}
	
	public static void copy(int[][]A,int[][]B) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				B[i][j]=A[i][j];
			}
		}
	}
	public static void count() {
		int answer=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]>0)answer+=board[i][j];
			}
		}
		System.out.println(answer);
	}
}
