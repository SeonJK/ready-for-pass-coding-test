package chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class chapter05_01 {

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList(1, -5, 2, 4, 3));
        inputs.add(Arrays.asList(2, 1, 1, 3, 2, 5, 4));
        inputs.add(Arrays.asList(6, 1, 7));

        for (List<Integer> list : inputs)
            System.out.println(Arrays.toString(solution(list)));
    }

    private static int[] solution(List<Integer> list) {
        int[] arr = list.stream().flatMapToInt(IntStream::of).toArray();
        Arrays.sort(arr);
        return arr;
    }
}
