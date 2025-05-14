package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class w7_매직스퀘어 {
	static int[][]arr=new int[3][3];//입력으로 주어진 배열
	static int[][]squares=new int[3][3];//탐색하며 만들어내는 매직스퀘어들
	static int answer = Integer.MAX_VALUE;
	static boolean checked[]=new boolean[10];//9개의 숫자 사용 여부 저장
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	public static void dfs(int depth) {
		if(depth==9) {
			//9개의 수를 모두 입력하여 만들었다면
			if(isMagicSquare()) {//매직 스퀘어라면
				int cost = getCost();
				answer = Math.min(answer, cost);
			}
		}
		for(int i=1;i<=9;i++) {
			if(!checked[i]) {
				checked[i]=true;
				squares[depth/3][depth%3]=i;
				dfs(depth+1);
				checked[i]=false;//원상 복구
			}
		}
	}
	public static boolean isMagicSquare() {
		//매직 스퀘어인지 확인하는 함수
		//행별로
		for(int i=0;i<3;i++) {
			int sum = 0;
			for(int j=0;j<3;j++) {
				sum+=squares[i][j];
			}
			if(sum!=15)return false;
		}
		//열별로
		for(int i=0;i<3;i++) {
			int sum = 0;
			for(int j=0;j<3;j++) {
				sum+=squares[j][i];
			}
			if(sum!=15)return false;
		}
		//대각선
		
		// 첫 번째 대각선 검사 (↘)
        int sum = squares[0][0] + squares[1][1] + squares[2][2];
        if (sum != 15) return false;

        // 두 번째 대각선 검사 (↙)
        sum = squares[0][2] + squares[1][1] + squares[2][0];
        if (sum != 15) return false;
		return true;
		
	}
	public static int getCost() {
		int cost = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cost+=Math.abs(arr[i][j]-squares[i][j]);
			}
		}
		return cost;
	}
}
