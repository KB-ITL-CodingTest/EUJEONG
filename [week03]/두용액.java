package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 두용액 {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		
		int[]arr = new int[N];
		for(int i=0;i<N;i++)arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int answer = Integer.MAX_VALUE;
		int start = 0;
		int end = N-1;
		int res1=0,res2=0;
		
		while(start<end) {
			int sum = arr[start]+arr[end];
			int abssum = Math.abs(sum);
			if(abssum<answer) {
				answer = abssum;
				res1 = arr[start];
				res2 = arr[end];
			}
			if(sum<0)start+=1;
			else end-=1;
		}
		System.out.println(res1 + " " + res2);
	}
}
