import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
       
        
        Stack<int[]> stack = new Stack<>(); // 인덱스와 높이를 배열로 스택에 저장
        
        for(int i=1;i<=N;i++) {
        	int now = Integer.parseInt(st.nextToken()); //현재 찾으려는 것
        	while(!stack.isEmpty()) {
        		if(stack.peek()[1]>=now) {//현재 탑보다 높이가 큰 경우
        			sb.append(stack.peek()[0]+" ");
        			break;
        		}
        		stack.pop();
        	}
        	if(stack.isEmpty()) {//닿을 수 있는 탑이 없음
        		sb.append("0 ");
        	}
            stack.push(new int[] {i,now});
        }
        
        System.out.println(sb.toString());
	}
}
