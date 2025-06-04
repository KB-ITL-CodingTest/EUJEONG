import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int []arr=new int[n+1];
		if(n==1)System.out.println(1%10007);
		else if(n==2)System.out.println(2%10007);
		else {
			arr[1]=1;
			arr[2]=2;
			for(int i=3;i<n+1;i++) {
				arr[i]=(arr[i-1]+arr[i-2])%10007;
			}
			System.out.print(arr[n]);
		}
		
		sc.close();
	}
}
