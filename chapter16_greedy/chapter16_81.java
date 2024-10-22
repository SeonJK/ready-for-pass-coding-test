package chapter16_greedy;

import java.util.*;

public class chapter16_81 {

    public static void main(String[] args) {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {1,3,2,5,4,5,2,3});
        inputs.add(new int[]{1,3,2,5,4,5,2,3});
        inputs.add(new int[]{1,1,1,1,2,2,2,3});

        int[] k = new int[] {6,4,2};

        for (int i = 0; i < inputs.size(); i++) {
          System.out.println(solution(inputs.get(i), k[i]));
        }
    }

    private static int solution(int[] input, int k) {
        int kind = 0;

        Arrays.sort(input);

        ArrayList<Item> items = new ArrayList<>();
        for (int i : input) {
            if (items.isEmpty() || items.stream().allMatch(item -> item.type != i)) {
                items.add(new Item(i, 1));
                items.sort(Comparator.comparingInt(o -> o.type));
            } else {
                items.get(i-1).count++;
            }
        }

        items.sort((o1, o2) -> Integer.compare(o2.count, o1.count));

        int remain = k;
        for (Item item : items) {
            if (item.count >= remain) {
                kind++;
                break;
            } else {
                kind++;
                remain -= item.count;
            }
        }

        return kind;
    }

    static class Item {
        int type;
        int count;

        public Item(int type, int count) {
            this.type = type;
            this.count = count;
        }
    }
}
