package KB_ITL;
import java.util.*;

public class w11_크게만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int K = sc.nextInt(); 
        String num = sc.next(); 

        Deque<Character> stack = new ArrayDeque<>();
        int remove = K;

        for (int i = 0; i < N; i++) {
            char current = num.charAt(i);
            while (!stack.isEmpty() && remove > 0 && stack.peekLast() < current) {
                stack.pollLast(); 
                remove--;
            }
            stack.offerLast(current);
        }

       
        while (remove-- > 0) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
