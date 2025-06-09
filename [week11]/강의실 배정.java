import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i][0]=s; arr[i][1]=t;
            
        }
        //최소의 강의실을 사용하려면 빨리 시작해서 빨리 끝나는 것이 앞에 위치해야 함 
            //우선 시작 시간을 기준으로 오름차순 정렬하기 
        Arrays.sort(arr,(o1,o2)->o1[0]==o2[1]?o1[1]-o2[1]:o1[0]-o2[0]);

        //종료 시간을 기준으로도 정렬해야 함
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for(int i=1;i<N;i++){
            if(pq.peek()<=arr[i][0]){
                 pq.poll();
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}
