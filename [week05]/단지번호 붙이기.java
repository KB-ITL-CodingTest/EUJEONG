import java.io.*;
import java.util.*;
public class Main {
	public static int N,home,total=0;
	public static int [][]arr;
	public static boolean [][]visited;
	public static int []dx = {-1,0,0,1};
	public static int []dy = {0,1,-1,0};
	public static ArrayList<Integer> villages=new ArrayList<>();
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		sc.nextLine();
		
		arr=new int[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input=sc.nextLine().trim();
			for(int j=0;j<N;j++) {
				arr[i][j]=input.charAt(j)-'0';
			}
		}
		
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					total++;//단지 수 증가
					home=0;//단지 내의 집의 수
					dfs(i,j);
					villages.add(home);
				}
			}
		}
		Collections.sort(villages);
		System.out.println(total);
		for(int i=0;i<villages.size();i++) {
			System.out.println(villages.get(i));
		}
		sc.close();
	}
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		home+=1;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if((nx>=0&&nx<N)&&(ny>=0&&ny<N)) {//범위 안에 존재하는 경우
				if(arr[nx][ny]==1&&!visited[nx][ny]) {
					//집이 존재하고 방문하지 않은 곳인 경우
					
					dfs(nx,ny);
				}
			}
			
		}
	}
}
