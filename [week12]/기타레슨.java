import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[]arr= new int[N];
		st = new StringTokenizer(bf.readLine());
		int start = 0;
		int end = 0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]>start)start=arr[i];
			end+=arr[i];
		}
		while(start<=end) {
			int mid = (start+end)/2;
			int sum=0;
			int count=0;
			for(int i=0;i<N;i++) {
				if(sum+arr[i]>mid) {
					count++;
					sum=0;
				}sum+=arr[i];
				
			}
			if(sum!=0)count++;
			if(count>M)start=mid+1;
			else end=mid-1;
			
		}
		System.out.println(start);
	}
}
