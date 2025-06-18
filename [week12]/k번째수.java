package KB_ITL;
import java.io.*;
public class w12_K번째수 {
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        long start = 1;
        long end = K;

        while(start<end){
            long mid = (start+end)/2;
            long count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(mid/i,N);
            }
            if(K<=count){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
