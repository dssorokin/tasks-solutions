package ValidBraces;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBraces {

    public static void main(String[] args) {
        System.out.println(isValid("[(])"));
    }

    public static boolean isValid(String braces) {
        // Add code here

        Stack commonStack = new Stack<String>();

        String[] bracesArr = braces.split("");
        try {
            for (int i = 0;i < braces.length();i++) {
                String currentSign = bracesArr[i];
                if (currentSign.equals("(") ) {
                    commonStack.push("(");
                } else if (currentSign.equals(")") && commonStack.pop() != "(") {
                    return false;
                } else if (currentSign.equals("[")) {
                    commonStack.push("[");
                } else if (currentSign.equals("]") && commonStack.pop() != "[") {
                    return false;
                } else if (currentSign.equals("{")) {
                    commonStack.push("{");
                } else if (currentSign.equals("}") && commonStack.pop() != "{") {
                    return false;
                }
            }
        } catch (EmptyStackException e) {
            return false;
        }
        return commonStack.size() == 0;
    }
}
