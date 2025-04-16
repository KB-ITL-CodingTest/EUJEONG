package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 배열합치기 {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int index_A=0;//배열A에서 사용할 포인터
		int index_B=0;//배열B에서 사용할 포인터
		
		int[]A=new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)A[i]=Integer.parseInt(st.nextToken());
		
		int[]B=new int[M];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++)B[i]=Integer.parseInt(st.nextToken());
		
		while(index_A<N&&index_B<M) {
			if(A[index_A]<=B[index_B]) {
				sb.append(A[index_A++]).append(" ");
			}else {
				sb.append(B[index_B++]).append(" ");
			}
		}
		while(index_A<N)sb.append(A[index_A++]).append(" ");
		while(index_B<M)sb.append(B[index_B++]).append(" ");
		
		System.out.print(sb.toString());
	}
}
