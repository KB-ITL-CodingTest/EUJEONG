import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		while(N>0) {
			if(N%5==0) {
				//5로 나누어지면
				answer+=(N/5);
				break;
			}else {
				N-=3;
				answer+=1;
			}
			if(N<0)answer=-1;
		}
		System.out.println(answer);
	}
}
