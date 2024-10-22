package chapter16_greedy;

import java.util.HashMap;

public class chapter16_03 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>() {{
                put(10, 11);
                put(7, 6);
                put(4, 17);
        }};

        System.out.println(solution(map, 15));
    }

    private static int solution(HashMap<Integer, Integer> input, int bag) {
        int result = 0;
        int index = -1;

        while(bag > 0) {
            System.out.println("bag="+bag);
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < input.size(); i++) {
                int tmp = input.get(input.keySet().stream().toList().get(i));
                if (tmp > max && bag-(input.keySet().stream().toList().get(i)) >= 0) {
                    index = input.keySet().stream().toList().get(i);
                    max = tmp;
                    System.out.println("index="+index + ", max="+max);
                }
            }

            if (max == Integer.MIN_VALUE)
                break;

            result += input.get(index);
            bag -= index;
            input.remove(index);
        }

        return result;
    }
}
