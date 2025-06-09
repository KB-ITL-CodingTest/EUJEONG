package KB_ITL;
import java.util.*;
import java.io.*;
public class w11_센서 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        int[]arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] gap = new int[N-1];
        for(int i=1;i<N;i++){
            gap[i-1]=(arr[i]-arr[i-1]);
        }
        Arrays.sort(gap);
        int answer = 0;
        for(int i=0;i<N-K;i++){
            answer+=gap[i];
        }
        System.out.println(answer);
    }
}
