package KB_ITL_CT;
import java.util.*;
public class 카드2 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++)q.offer(i);
		
		while(true) {
			if(q.size()==1) {
				System.out.println(q.poll());
				return;
			}
			q.poll();
			q.offer(q.poll());
		}
	}
}
