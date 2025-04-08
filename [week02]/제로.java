import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<k;i++) {
			int now = sc.nextInt();
			if(now==0) {
				stack.pop();
			}else {
				stack.push(now);
			}
			
		}
		
		int sum = 0;
		for(Integer e : stack)sum+=e;
		System.out.println(sum);
		sc.close();
	}
}
