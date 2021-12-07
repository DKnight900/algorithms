package codesignal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ReverseInParentheses {
    public static void main(String[] args) {
        ReverseInParentheses reverseInParentheses = new ReverseInParentheses();
        System.out.println(reverseInParentheses.reverseInParentheses("foo(bar(baz))blim"));
    }

    String reverseInParentheses(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);
        int indexStart;
        int indexEnd;
        while(sb.indexOf("(") != -1) {
            indexStart = sb.lastIndexOf("(");
            indexEnd = sb.indexOf(")", indexStart);
            sb.replace(indexStart, indexEnd + 1,
                new StringBuilder(sb.substring(indexStart + 1, indexEnd)).reverse().toString());
        }
        return sb.toString();
    }


}
