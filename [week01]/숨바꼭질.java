package KB_ITL_CT;
import java.util.*;
public class 숨바꼭질 {
	
	public static void main(String[]args) {
		final int MAX = 100000;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[]visited = new boolean[MAX+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N,0});
		visited[N]=true;
		while(true) {
			int []now = q.poll();
			int value = now[0];
			int seconds = now[1];
			if(value==K) {//수빈이가 K위치에 도달한 경우 
				System.out.println(seconds);
				break;
			}
			
			if(!visited[value-1]&&value-1>=0&&value-1<=MAX) {
				q.add(new int[] {value-1,seconds+1});
				visited[value-1]=true;
			}
			if(!visited[value+1]&&value+1>=0&&value+1<=MAX) {
				q.add(new int[] {value+1,seconds+1});
				visited[value+1]=true;
			}
			if(!visited[value*2]&&value*2>=0&&value*2<=MAX) {
				q.add(new int[] {value*2,seconds+1});
				visited[value*2]=true;
			}
			
		}
		sc.close();
	}
	
}
