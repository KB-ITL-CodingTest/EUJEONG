package KB_ITL;
import java.io.*;
import java.util.*;
public class w12_예산 {
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[]area = new int[N];
        for(int i=0;i<N;i++){
            area[i]=Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bf.readLine());//배정된 국가 총 예산액 

        int start = 0;
        int end =Arrays.stream(area).max().getAsInt();
        int answer = 0;
        int sum = 0;
        while(start<=end){
            int mid = (start+end)/2;//mid 는 배정된 예산
            sum = get_budget(mid, area);//배정된 예산으로 나오게 되는 총 예산
 
            if(sum>M){
                end = mid-1;
            }else{
                answer = mid;
                start = mid + 1;
            }
        }
  
        
        System.out.println(answer);
        
    }
    public static int get_budget(int high, int[]area){
        int sum = 0;
        for(int i=0;i<area.length;i++){
            if(area[i]<high)sum+=area[i];
            else sum+=high;
        }
        return sum;
    }
}
