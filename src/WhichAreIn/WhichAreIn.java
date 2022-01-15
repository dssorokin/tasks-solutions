package WhichAreIn;


import java.util.*;

public class WhichAreIn {

    public static void main (String[] args) {
        System.out.println(inArray(new String[]{ "arp", "live", "strong" }, new String[] { "lively", "alive", "harp", "sharp", "armstrong" }));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> result = new TreeSet<>(Comparator.naturalOrder());
        for (int i = 0;i < array1.length;i++) {
            String str1 = array1[i];
            for (int j = 0;j < array2.length;j++) {
                String str2 = array2[j];
                if (str2.contains(str1)) {
                    result.add(str1);
                }
            }
        }
        return result.toArray(String[]::new);
    }
}
