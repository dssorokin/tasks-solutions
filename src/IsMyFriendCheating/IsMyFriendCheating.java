package IsMyFriendCheating;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IsMyFriendCheating {

    public static void main(String[] args) {
        System.out.println(removNb(26));
    }

    public static List<long[]> removNb(long n) {
        // your code
        double sum = ((n + 1) * n / 2);
        List<long[]> result = new ArrayList<>();
        for (int i = 1;i <= n;i++) {
            Double possibleSecondDigit =  (sum - i) / (i + 1);
            if (possibleSecondDigit % 1 == 0 && possibleSecondDigit < n) {
                long[] pair = new long[]{i, possibleSecondDigit.longValue()};
                result.add(pair);
            }
        }
        return result;
    }
}
