import java.io.*;
import java.util.*;
public class Main {
	public static class change{//방향 변화를 저장한 정보
		int X;
		char C;
		public change(int X, char C) {
			this.X=X;
			this.C=C;
		}
	}
	
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken()); //사과의 개수
		int direct = 0;
		int []dx = {0,1,0,-1};
		int []dy = {1,0,-1,0};
		
		int[][]board = new int[N][N];
		board[0][0]=2; //초기 뱀이 위치하는 곳
		//사과의 위치 입력받기
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int k_row = Integer.parseInt(st.nextToken());
			int k_col = Integer.parseInt(st.nextToken());
			board[k_row-1][k_col-1]=1; //사과 있는 곳은 1로 표시
		}
		
		st = new StringTokenizer(bf.readLine());
		int L = Integer.parseInt(st.nextToken());//뱀의 방향 변환 횟수 
		
		Queue<change>queue = new LinkedList<>();
		//L번의 방향 정보 저장하기
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			queue.add(new change(x,c));
		}
		
		int time=0;
		int head_x=0, head_y=0;//초기 뱀의 머리 위치
		int tail_x=0, tail_y=0; //초기 뱀의 꼬리 위치
		Queue<int[]> tail_info = new LinkedList<>();
		tail_info.add(new int[] {tail_x,tail_y});//나중에 꼬리 위치 확인하려고
		while(true) {
			time+=1;
			
			int new_x = head_x + dx[direct];//새롭게 이동한 뱀의 위치
			int new_y = head_y + dy[direct];
			
			//새롭게 이동한 곳이 벽이거나 뱀의 몸 자기 자신일 경우 게임 종료
			if((new_x<0||new_x>=N)||(new_y<0||new_y>=N)||board[new_x][new_y]==2)break;
			
			tail_info.add(new int[] {new_x,new_y});
			//새롭게 이동한 곳에 사과가 있을 경우
			if(board[new_x][new_y]==1) {
				board[new_x][new_y]=2;
				
			}else if(board[new_x][new_y]==0){//사과가 없을 경우
				//몸 길이 줄여 꼬리가 위치한 칸 비워주기
				board[tail_x][tail_y]=0;
				board[new_x][new_y]=2;
				//새로운 꼬리의 위치로 갱신
				tail_info.poll();
				tail_x=tail_info.peek()[0];
				tail_y=tail_info.peek()[1];
				
			}
			head_x=new_x;
			head_y=new_y; //새로운 머리의 위치
			//방향 변경 여부 체크하기
			if(!queue.isEmpty()) {
				if(time==queue.peek().X) {
					if(queue.peek().C=='L') {
						direct=(direct+3)%4;
					}else if(queue.peek().C=='D') {
						
						direct=(direct+1)%4;
					}
					queue.poll();
				}
			}
		}
		System.out.println(time);
	}
}
