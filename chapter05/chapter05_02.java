package chapter05;

import java.util.*;

public class chapter05_02 {

    public static void main(String[] args) {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {4, 2, 2, 1, 3, 4});
        inputs.add(new int[]{2, 1, 1, 3, 2, 5, 4});

        for (int[] list : inputs) {
          System.out.println(Arrays.toString(solution(list)));
        }
    }

    private static int[] solution(int[] input) {
        // 풀이1. Stream을 이용한 풀이
        Integer[] output = Arrays.stream(input)
                .boxed()
                .distinct()
                .toArray(Integer[]::new);

        Arrays.sort(output, Collections.reverseOrder());

        return Arrays.stream(output)
                .mapToInt(Integer::intValue)
                .toArray();

        // 풀이2. TreeSet을 이용한 풀이
        // 중복값 제거, 내림차순 정렬
//        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
//        for (int num : input) {
//            set.add(num);
//        }
//
//        // int형 배열에 담아서 반환
//        int[] result = new int[set.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = set.pollFirst();
//        }
//        return result;
    }
}
