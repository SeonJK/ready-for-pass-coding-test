package chapter06_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class chapter06_10 {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("[](){}");
        inputs.add("}]()[{");
        inputs.add("[)(]");
        inputs.add("}}}");

        for (String str : inputs) {
          System.out.println(solution(str));
        }
    }

    private static int solution(String s) {
        // 괄호 정보를 저장.
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만듦
        s += s;
        int answer = 0;

        // 확인할 문자열의 시작 인덱스 이동
        A:for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 짝이 맞지 않을 경우 내부 for문을 종료하고 for문 A로 이동
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }

            // 내부 for문에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임.
            if (stack.isEmpty())
                answer++;
        }

        return answer;
    }
}
