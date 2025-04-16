package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 회전초밥 {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());//회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken());//초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());//연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());//쿠폰 번호

        int []arr = new int[N];//벨트에 놓인 초밥들
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = k-1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //k개의 초밥을 저장할 초기 map

        //처음 시작했을 때의 k개의 초밥 (초기 윈도우 구성) 
        for(int i=start;i<=end;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int answer=0;
        if(map.containsKey(c)) {
        	answer = map.size();
        }else {
        	answer=map.size()+1;
        }
        
        //원형이므로 %N 이용해서 모두 검사하기
        //N번 회전하면서 검사
        //슬라이딩 윈도우 시작점 = 1, 끝나는 점 = 시작점 + k-1 
        for(int i=1;i<N;i++) {
        	//제거될 초밥
        	int remove = arr[(i-1)%N];
        	map.put(remove, map.get(remove)- 1);
        	if(map.get(remove)==0) {
        		map.remove(remove);//제거한 초밥의 종류가 더 이상 현재 탐색하는 k개 내에 존재하지 않을 경우 map에서 완전 제거
        	}
        	
        	//추가될 초밥
        	int add = arr[(i+k-1)%N];
        	map.put(add,map.getOrDefault(add, 0)+1);
        	
        	//쿠폰 포함 여부 확인
        	if(map.containsKey(c)) {
        		answer = Math.max(answer, map.size());
        	}else {
        		answer = Math.max(answer, map.size()+1);
        	}
        }

        System.out.println(answer);
    }
}
