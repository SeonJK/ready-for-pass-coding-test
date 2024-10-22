package chapter16_greedy;

import java.util.ArrayList;
import java.util.List;

public class chapter16_82 {

    public static void main(String[] args) {
        List<int[]> stations = new ArrayList<>();
        stations.add(new int[] {4, 11});
        stations.add(new int[]{9});

        int[] n = new int[]{11, 16};
        int[] w = new int[]{1,2};

        for (int i = 0; i < n.length; i++) {
          System.out.println(solution(n[i], stations.get(i), w[i]));
        }
    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;   // 현재 탐색하는 아파트의 위치
        int idx = 0;        // 설치된 기지국의 인덱스

        while (location <= n) {
            // 기지국이 설치된 위치에 도달한 경우
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            }
            // 기지국이 설치되지 않은 위치인 경우
            else {
                location += 2 * w + 1;  // 기지국을 설치하고 해당 범위를 넘어감
                answer++;
            }
        }

        return answer;
    }
}
