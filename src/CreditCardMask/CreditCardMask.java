package CreditCardMask;

public class CreditCardMask {

    public static void main(String[] args) {
        System.out.println(maskify(""));
        System.out.println(maskify("4556364607935616"));
        System.out.println(maskify("64607935616"));
        System.out.println(maskify("1"));
    }

    public static String maskify(String str) {
        final int indexOfLast4Dig = str.length() - 4;
        if (indexOfLast4Dig <= 0) {
            return str;
        }
        final String last4Dig = str.substring(indexOfLast4Dig);
        final String maskedPart = str.substring(0, indexOfLast4Dig).replaceAll(".", "#");
        return maskedPart + last4Dig;
    }
}
