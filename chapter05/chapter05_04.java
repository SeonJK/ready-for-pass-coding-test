package chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class chapter05_04 {

    public static void main(String[] args) {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {1,2,3,4,5});
        inputs.add(new int[]{1,3,2,4,2});

        for (int[] list : inputs) {
            System.out.println(Arrays.toString(solution(list)));
        }
    }

    private static int[] solution(int[] input) {
        int[][] supo = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        int[] correct = new int[3];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < supo.length; j++) {
                if (input[i] == supo[j][i % supo[j].length]) {
                    correct[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(correct).max().getAsInt();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < correct.length; i++) {
            if (correct[i] == maxScore)
                result.add(i+1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
