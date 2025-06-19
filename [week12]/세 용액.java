package KB_ITL;

import java.io.*;
import java.util.*;
public class w12_세용액 {
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] waters = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            waters[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waters);
        long answer = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long) waters[i] + waters[left] + waters[right];

                if (Math.abs(sum) < Math.abs(answer)) {
                    answer = sum;
                    result[0] = waters[i];
                    result[1] = waters[left];
                    result[2] = waters[right];
                }

                if (sum == 0) {
                    System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    return; 
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
    }
}
