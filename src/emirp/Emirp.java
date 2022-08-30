package emirp;

import java.util.LinkedList;
import java.util.List;

public class Emirp {

    public static void main() {
        long[] resArr = findEmirp(100);
        for (int i = 0;i < resArr.length;i++){
            System.out.println(resArr[i]);
        }
    }

    public static long[] findEmirp(long n){
        // your code
        long start = System.currentTimeMillis();
        boolean[] isComposite = getSieve(n * 10);

        List<Long> emirpNums = new LinkedList<>();
        for (int k = 0;k <= n;k++) {
            long reverseDigit = reverseDigit(k);
            if (!isComposite[k] && reverseDigit != k && !isComposite[(int) reverseDigit]) {
                emirpNums.add((long) k);
            }
        }
        System.out.println((System.currentTimeMillis() - start) / 1000);

        long[] result = new long[3];
        result[0] = emirpNums.size();
        result[1] = emirpNums.stream().max((l1, l2) -> (int) (l1 - l2) ).orElse(0L);
        result[2] = emirpNums.stream().reduce(Long::sum).orElse(0L);

        return result;
    }

    private static boolean[] getSieve(long n) {
        double digitToStop = Math.sqrt(n);
        boolean[] isComposite = new boolean[(int) n];
        for (int i = 4; i < n; i += 2) {
            isComposite[i] = true;
        }
        int nextPrime = 3;
        while(nextPrime <= digitToStop) {
            for (int j = nextPrime * 2; j < n; j += nextPrime) {
                isComposite[j] = true;
            }
            nextPrime += 2;
            while (nextPrime <= n && isComposite[nextPrime]) {
                nextPrime += 2;
            }
        }
        return isComposite;
    }

    private static long reverseDigit(long digit) {
        long reverse = 0;
        while (digit != 0) {
            long lastDigit = digit % 10;
            reverse = reverse * 10 + lastDigit;
            digit = digit / 10;
        }
        return reverse;
    }
}
