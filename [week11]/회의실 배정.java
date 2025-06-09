import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][]arr= new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(a1,b1)->{
			if(a1[1]==b1[1])return a1[0]-b1[0];
			else return a1[1]-b1[1];
		});
		int answer=1;
		int before_end = arr[0][1];
		for(int i=1;i<n;i++) {
			if(arr[i][0]>=before_end) {
				answer++;
				before_end = arr[i][1];
			}
		}
		System.out.println(answer);
	}
}
