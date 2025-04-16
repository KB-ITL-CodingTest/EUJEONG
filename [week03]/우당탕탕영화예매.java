package KB_ITL_CT;

import java.io.*;
import java.util.*;

public class 우당탕탕영화예매 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken()); //행
        int M = Integer.parseInt(st.nextToken()); //열
        int K = Integer.parseInt(st.nextToken()); //동아리원의 수
        
        int [][]arr = new int[N][M];
        if(M<K) {
        	System.out.println(0);
        	return;
        }
        for(int i=0;i<N;i++) { //arr 배열에 정보 저장하기 
            String s = bf.readLine();
            for(int j=0;j<M;j++) {
                if(s.charAt(j)=='1') {arr[i][j]=1;}
                else{arr[i][j]=0;}
            }
        }
        
        int answer = 0;
        for(int i=0;i<N;i++) {
        	int count = 0;
            for(int j=0;j<K;j++) {
                if(arr[i][j]==0){
                    count+=1;
                }
            }
            if(count>=K)answer+=1;
            int s = 0;
            for(int t = K;t<M;t++) {
            	if(arr[i][t]==0)count+=1;
            	if(arr[i][s]==0)count-=1;
            	if(count>=K)answer+=1;
            	s+=1;
            }
        }
        System.out.println(answer);
    }
}
