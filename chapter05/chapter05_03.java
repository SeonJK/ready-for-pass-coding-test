package chapter05;

import java.util.*;

public class chapter05_03 {

    public static void main(String[] args) {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {2, 1, 3, 4, 1});
        inputs.add(new int[]{5, 0, 2, 7});

        for (int[] list : inputs) {
            System.out.println(Arrays.toString(solution(list)));
        }
    }

    private static int[] solution(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i+1; j < input.length; j++) {
                set.add(input[i] + input[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
