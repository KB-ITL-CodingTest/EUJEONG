import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		int[]answer = new int[t];
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][]arr = new int[k+1][n+1];
			for(int j=1;j<=n;j++)arr[0][j]=j;
			for(int j=1;j<=k;j++) {
				arr[j][1]=arr[j-1][1];
				for(int s=2;s<=n;s++) {
					arr[j][s]=arr[j][s-1]+arr[j-1][s];
				}
			}
			answer[i]=arr[k][n];
		}
		for(Integer e : answer)System.out.println(e);
	}
}
