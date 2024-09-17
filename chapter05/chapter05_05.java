package chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chapter05_05 {

    public static void main(String[] args) {
        List<int[][]> inputs1 = new ArrayList<>();
        inputs1.add(new int[][] {{1,4}, {3,2}, {4,1}});
        inputs1.add(new int[][] {{2,3,2}, {4,2,4}, {3,1,4}});

        List<int[][]> inputs2 = new ArrayList<>();
        inputs2.add(new int[][] {{3,3}, {3,3}});
        inputs2.add(new int[][] {{5,4,3}, {2,4,1}, {3,1,1}});

        for (int i = 0; i < inputs1.size(); i++) {
            int[][] result = solution(inputs1.get(i), inputs2.get(i));
            for (int j = 0; j < result.length; j++) {
                System.out.println(Arrays.toString(result[j]));
            }
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    // 책에서는 arr1[0].length를 사용했지만, arr2.length도 가능.
                    // why? 행렬의 곱셈은 첫번째 행렬의 열과 두번째 행렬의 행의 값이 같아야 하기 때문
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}
