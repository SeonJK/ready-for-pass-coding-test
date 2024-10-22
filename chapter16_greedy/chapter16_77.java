package chapter16_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chapter16_77 {

    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(123);
        inputs.add(350);


        for (int amount : inputs) {
          System.out.println(Arrays.toString(solution(amount)));
        }
    }

    private static int[] solution(int amount) {
        ArrayList<Integer> result = new ArrayList<>();

        while(amount >= 100) {
            result.add(100);
            amount -= 100;
        }
        while (amount >= 50) {
            result.add(50);
            amount -= 50;
        }
        while (amount >= 10) {
            result.add(10);
            amount -= 10;
        }
        while (amount > 0) {
            result.add(1);
            amount -= 1;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
