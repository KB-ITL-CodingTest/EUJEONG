import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>(); // 집 좌표 저장
    static List<int[]> chickens = new ArrayList<>(); // 치킨집 좌표 저장
    static int minDistance = Integer.MAX_VALUE; // 최소 치킨 거리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 도시 정보 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    houses.add(new int[]{i, j}); // 집 좌표 저장
                } else if (input == 2) {
                    chickens.add(new int[]{i, j}); // 치킨집 좌표 저장
                }
            }
        }

        // 치킨집 조합을 선택 (백트래킹 시작)
        backtrack(new ArrayList<>(), 0);
        System.out.println(minDistance); // 최소 치킨 거리 출력
        sc.close();
    }

    // 백트래킹을 사용하여 치킨집 조합 선택
    public static void backtrack(List<int[]> selectedChickens, int start) {
        if (selectedChickens.size() == M) { // M개의 치킨집 선택 완료
            int distance = calculateChickenDistance(selectedChickens);
            minDistance = Math.min(minDistance, distance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.add(chickens.get(i)); // 치킨집 선택
            backtrack(selectedChickens, i + 1);    // 다음 치킨집 선택
            selectedChickens.remove(selectedChickens.size() - 1); // 선택 취소
        }
    }

    // 선택한 치킨집 조합으로 도시의 치킨 거리 계산
    public static int calculateChickenDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, dist); // 가장 가까운 치킨집 거리
            }
            totalDistance += minDist; // 해당 집의 치킨 거리 추가
        }

        return totalDistance;
    }
}
