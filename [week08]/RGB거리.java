package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class w8_RGB거리 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][]houses = new int[n][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				houses[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]cost = new int[n][3];
		cost[0][0]=houses[0][0];//빨강
		cost[0][1]=houses[0][1];//초록
		cost[0][2]=houses[0][2];//파랑 
		
		for(int i=1;i<n;i++) {
			cost[i][0]=Math.min(cost[i-1][1], cost[i-1][2])+houses[i][0];
			cost[i][1]=Math.min(cost[i-1][0], cost[i-1][2])+houses[i][1];
			cost[i][2]=Math.min(cost[i-1][0], cost[i-1][1])+houses[i][2];
		}
		System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));
	}
}
