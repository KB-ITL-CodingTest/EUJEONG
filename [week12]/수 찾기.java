import java.io.*;
import java.util.*;
public class Main {
	public static int[]A;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)A[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++) {
			boolean find = false;
			int start = 0;
			int end = A.length-1;
			
			
			int found = Integer.parseInt(st.nextToken());
			
			while(start<=end) {
				int mid = (end+start)/2;
				if(found<A[mid]) {
					end = mid-1;
				}else if(found>A[mid]) {
					start = mid+1;
				}else {
					find = true;
					break;
				}
			}
			if(find)System.out.println(1);
			else System.out.println(0);
		}
	}
	
}
