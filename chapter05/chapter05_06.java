package chapter05;

import java.util.*;

public class chapter05_06 {

    public static void main(String[] args) {
            List<int[]> stages = new ArrayList<>();
            stages.add(new int[] {2, 1, 2, 6, 2, 4, 3, 3});
            stages.add(new int[]{4, 4, 4, 4, 4});

            int[] n = new int[]{5,4};

            for (int i = 0; i < stages.size(); i++) {
              System.out.println(Arrays.toString(solution(n[i], stages.get(i))));
            }
        }

        private static int[] solution(int n, int[] input) {
            // 스테이지에 도달한 플레이어 수 계산
            int[] arr1 = new int[n+2];
            for (int i = 0; i < input.length; i++) {
                arr1[input[i]]++;
            }
            // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            HashMap<Integer, Double> fails = new HashMap<>();
            double total = input.length;

            // 각 스테이지를 순회하며 실패율 계산
            for (int i = 1; i <= n; i++) {
                if (arr1[i] == 0) {
                    fails.put(i, 0.);
                } else {
                    fails.put(i, arr1[i] / total);
                    // 다음 스테이지 실패율 계산을 위해 현재 스테이지 인원을 뺌
                    total -= arr1[i];
                }
            }

            // 내림차순하여 반환
            return fails.entrySet().stream()
                    .sorted(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())))
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
}
