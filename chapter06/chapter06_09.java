package chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class chapter06_09 {

    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(10);
        inputs.add(27);
        inputs.add(12345);

        for (int decimal : inputs) {
          System.out.println(solution(decimal));
        }
    }

    private static String solution(int decimal) {
        // 1. StringBuilder만 사용해서 푸는 방법
//        StringBuilder result = new StringBuilder();
//
//        while (decimal > 0) {
//            result.append(decimal % 2);
//            decimal /= 2;
//        }
//
//        return result.reverse().toString();

        // 2. Stack을 이용해서 푸는 방법
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
