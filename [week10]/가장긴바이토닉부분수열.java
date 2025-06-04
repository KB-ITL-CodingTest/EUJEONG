import java.io.*;
import java.util.*;
public class Main {
	static int[]arr;
	static int[]leftdp; static int[]rightdp;
	static int n;
	public static void main(String[]args)throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		leftdp = new int[n];//왼쪽 dp
		rightdp=new int[n];//오른쪽 dp
		
		leftdp[0]=1;
		rightdp[n-1]=1;
		for(int i=1;i<n;i++) {
			get_left(i);
			get_right(i);
		}
		
		
		for(int i=n-2;i>=0;i--) {
			int value = get_right(i);
			rightdp[i]=value;
		}
		
		int[]dp = new int[n];//최종 dp
		for(int i=0;i<n;i++) {
			dp[i]=leftdp[i]+rightdp[i];
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]-1);
	}
	public static int get_left(int index) {
		if(leftdp[index]==0) {
			leftdp[index]=1;//방문하지 않은 곳은 1로 
			for(int i=index-1;i>=0;i--) {
				if(arr[i]<arr[index]) {
					leftdp[index]=Math.max(leftdp[index], get_left(i)+1);
				}
			}
		}
		return leftdp[index];
		
	}
	
	public static int get_right(int index) {
		if(rightdp[index]==0) {
			rightdp[index]=1;
			for(int i=index+1;i<rightdp.length;i++) {
				if(arr[i]<arr[index]) {
					rightdp[index]=Math.max(rightdp[index], get_right(i)+1);
				}
			}
		}
		return rightdp[index];
	}
}
