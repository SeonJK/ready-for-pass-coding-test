package chapter05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class chapter05_07 {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("ULURRDLLU");
        inputs.add("LULLLLLLU");

        for (String str : inputs) {
//          System.out.println(mySolution(str));
            System.out.println(solution(str));
        }
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static int solution(String input) {
        initLocation();
        int x = 5, y = 5;
        // 겹치는 좌표는 1개로 처리
        HashSet<String> answer = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            int[] offset = location.get(input.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny))
                continue;

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

    private static void initLocation() {
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});
    }

    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    private static int mySolution(String input) {
        // 문제는 길의 길이를 구하는 것이기 때문에 지점을 구하는 것은 맞지 않다.
        int MAX = 10;
        int MIN = 0;

        int[][] map = new int[MAX+1][MAX+1];
        int newRoute = 0;

        int[] pos = new int[]{5,5};
        map[5][5] = 1;

        for (char c : input.toCharArray()) {
            switch (c) {
                case 'U' -> {
                    if (pos[1] != MAX) {
                        pos[1]++;
                    }
                }
                case 'D' -> {
                    if (pos[1] != MIN) {
                        pos[1]--;
                    }
                }
                case 'R' -> {
                    if (pos[0] != MAX) {
                        pos[0]++;
                    }
                }
                case 'L' -> {
                    if (pos[0] != MIN) {
                        pos[0]--;
                    }
                }
                default -> {}
            }

            if (map[pos[0]][pos[1]] == 0) {
                map[pos[0]][pos[1]] = 1;
                newRoute++;
            }
        }

        return newRoute;
    }
}
