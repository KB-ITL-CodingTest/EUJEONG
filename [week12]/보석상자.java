package KB_ITL;
import java.io.*;
import java.util.*;
public class w12_보석상자 {
    public static void main(String[]args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max_jewelry = 0; //학생이 가질 수 있는 최대 보석의 개수
        int[] jewerly = new int[M];
        for(int i=0;i<M;i++){
            jewerly[i]=Integer.parseInt(bf.readLine());
            if(jewerly[i]>max_jewelry) max_jewelry=jewerly[i];//가질 수 있는 최대 보석의 개수는 주어진 보석들 중 개수가 많은 보석의 개수
        }

        int start = 1;
        while(start<max_jewelry){
            int mid = (start+max_jewelry)/2;
            long sum = 0;//필요한 학생의 수
            for(int jew : jewerly){
                if(jew%mid==0){
                    sum+=(jew/mid);
                }else{
                    sum+=((jew/mid)+1);
                }
            }
            //필요한 학생의 수가 주어진 학생의 수보다 많다면 -> 한 명이 가질 수 있는 보석의 개수를 늘려야 함
            if(sum>N)start=mid+1;
            else max_jewelry=mid;
        }
        System.out.println(start);
    }
}
