package chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class chapter06_08 {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("()()");
        inputs.add("(())()");
        inputs.add(")()(");
        inputs.add("(()(");

        for (String str : inputs) {
          System.out.println(solution(str));
        }
    }

    private static boolean solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (Character c : input.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.empty()){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.empty();
    }
}
