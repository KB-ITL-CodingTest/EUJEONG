import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();  // 테스트 케이스 수
        int[] coins = {25, 10, 5, 1};  // 쿼터, 다임, 니켈, 페니
        
        for (int i = 0; i < test; i++) {
            int remain = sc.nextInt();  // 거스름돈(센트 단위)
            int[] answer = new int[4];  // 각각의 동전 수
            
            for (int j = 0; j < coins.length; j++) {
                answer[j] = remain / coins[j];  // 동전 개수 계산
                remain = remain % coins[j];  // 나머지 거스름돈
            }
            
            // 결과 출력
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
