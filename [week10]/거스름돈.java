import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int rest = sc.nextInt();
		int five,two;
        if(rest==1||rest==3) {
			System.out.print(-1);
			return;
		}
		if((rest%5)%2==1) {
			five = rest/5-1;
			rest = rest-(5*five);
			two = rest/2;
		}else {
			five = rest/5;
			rest = rest-(5*five);
			two = rest/2;
		}
		int answer = five + two;
		System.out.print(answer);
        sc.close();
	}
}
