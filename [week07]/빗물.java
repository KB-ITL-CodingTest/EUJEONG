package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class w7_빗물 {
	static int answer = 0;
	static int H,W;
	static int[]arr;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<W;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start,end;
		for(int i=0;i<W;i++) {
			if(arr[i]!=0) {
				start = i;
				int height = arr[i];
				end = get_end(start,height);
				if(end==-1)break;
				if(end==W-1&&arr[end]==0)break;
				if(arr[start]<=arr[end]) {
					caculate(start,end,arr[start]);
				}else if(arr[start]>arr[end]) {
					caculate(start,end,arr[end]);
				}
				i=end-1;
			}
		}
		System.out.println(answer);
	}
	public static int get_end(int start, int height) {
		if(start==W-1)return -1;
		for(int i=start+1;i<W;i++) {
			if(arr[i]>=height)return i;
		}
		//높이가 낮아지는 지점 중 높이가 가장 높은 것 저장하기
		int max = 0;
		int max_index = -1;
		for(int i=start+1;i<W;i++) {
			if(arr[i]<height&&arr[i]!=0) {
				if(max<arr[i]) {
					max = arr[i];
					max_index = i;
				}
				
			}
		}
		return max_index;
	}
	public static void caculate(int start,int end,int height) {
		for(int i=start+1;i<end;i++) {
			answer+=(height-arr[i]);
		}
	}
}
