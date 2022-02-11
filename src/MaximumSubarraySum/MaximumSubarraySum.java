package MaximumSubarraySum;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int sequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        List<Integer> possibleSums = new ArrayList<>();

        for (int i = 0;i < arr.length;i++) {
            int sumOfSubarray = 0;
            for (int j = i;j < arr.length;j++) {
                int curDigit = arr[j];
                sumOfSubarray += curDigit;
                possibleSums.add(sumOfSubarray);
            }
        }

        int max = possibleSums.stream().mapToInt(i -> i).max().orElse(0);
        return Math.max(max, 0);
    }
}
