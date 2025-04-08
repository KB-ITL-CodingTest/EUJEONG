import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		for(int i=1;i<=n;i++) {
			int now = sc.nextInt();//현재 만드려는 수열의 원소
			
			while(num<=now) {
				sb.append("+\n");
				stack.push(num);
				num+=1;
			}
			int top = stack.peek();//스택에서 꺼낸 값
			if(top==now) {
				sb.append("-\n");
				stack.pop();
			}else {
				System.out.println("NO");
				return;
			}
			
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
