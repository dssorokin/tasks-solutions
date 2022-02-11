package RangeExtraction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RangeExtraction {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{37,39,42,44,45,47,50,51}));
    }

    public static String rangeExtraction(int[] arr) {
        int firstDigitInRange = arr[0];
        int lastDigit = arr[0];
        int countRange = 0;
        List<String> formattedStr = new ArrayList<>();
        for (int i = 0;i < arr.length;i++) {
            int currentDigit = arr[i];
            boolean isLastInArr = i == arr.length - 1;
            if (currentDigit - lastDigit > 1) {
                if (countRange >= 3) {
                    formattedStr.add(firstDigitInRange + "-" + lastDigit);
                } else if (countRange == 2) {
                    formattedStr.add(String.valueOf(firstDigitInRange));
                    formattedStr.add(String.valueOf(lastDigit));
                } else {
                    formattedStr.add(String.valueOf(lastDigit));
                }
                firstDigitInRange = currentDigit;
                countRange = 1;
            } else {
                countRange++;
            }
            lastDigit = currentDigit;
            if (isLastInArr) {
                if (countRange >= 3) {
                    formattedStr.add(firstDigitInRange + "-" + lastDigit);
                }  else if (countRange == 2) {
                    formattedStr.add(String.valueOf(firstDigitInRange));
                    formattedStr.add(String.valueOf(lastDigit));
                } else {
                    formattedStr.add(String.valueOf(lastDigit));
                }
            }
        }
        return formattedStr.stream().collect(Collectors.joining(","));
    }
}
