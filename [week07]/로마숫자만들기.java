package KB_ITL_CT;
import java.util.*;

public class w7_로마숫자만들기 {
    static int N;
    static int[] arr = new int[]{1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(set.size());
        sc.close();
    }

    public static void dfs(int sum, int depth, int start) {
        // sum은 현재까지의 합, depth는 사용한 숫자 개수, start는 다음 숫자 시작 인덱스
        if (depth == N) {
            set.add(sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            // 이전에 사용한 숫자 이상만 사용하여 중복 방지
            dfs(sum + arr[i], depth + 1, i);
        }
    }
}
