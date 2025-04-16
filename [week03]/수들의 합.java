package KB_ITL_CT;
import java.util.*;
public class 수들의합 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 1,end=1;
		int answer=1;
		int sum = 1;
		while(true) {
			if(end==N)break;
			if(sum<N) {
				end+=1;
				sum+=end;
			}else if(sum>N) {
				sum-=start;
				start+=1;
			}else if(sum==N){
				answer+=1;
				end+=1;
				sum+=end;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
