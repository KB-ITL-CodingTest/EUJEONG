import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[]count_zero = new long[n+1];
		long[]count_one = new long[n+1];
		count_zero[1]=0;
		count_one[1]=1;
        if(n==1) {
			System.out.println(1);
			return;
		}
		for(int i=2;i<=n;i++) {
			count_zero[i]=count_one[i-1]+count_zero[i-1];
			count_one[i]=count_zero[i-1];
		}
		System.out.println(count_zero[n]+count_one[n]);
		sc.close();
	}
}
