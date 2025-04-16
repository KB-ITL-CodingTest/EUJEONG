import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		int m = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int start = 0, end=1;
		int count = 0;
		while(start!=n-1) {
			if(end==n) {
				start++;
				if(start==n-1)break;
				end=start+1;
			}
			if(arr[start]+arr[end]==m) {
				count++;
				start++;
				end=start+1;
			}else {
				end++;
			}
		}
		System.out.println(count);
	}
}
