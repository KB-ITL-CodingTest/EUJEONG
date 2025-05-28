
import java.util.*;
public class Main {
	public static int[]arr=new int[11];
	public static void main(String[]args) {
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for(int i=4;i<11;i++) {
			arr[i]=arr[i-3]+arr[i-2]+arr[i-1];
		}
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int []answer=new int[num];
		for(int i=0;i<num;i++) {
			int n=sc.nextInt();
			answer[i]=arr[n];
		}
		for(int i=0;i<num;i++)System.out.println(answer[i]);
		
		sc.close();
	}
}
