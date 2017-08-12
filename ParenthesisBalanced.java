/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 *
 * @author DKnight900
 * 
 * Determine whether a list of parenthesis is balanced or not, for instance:
 * 
 * ()() -> Is balanced
 * (( -> Is NOT balanced
 * 
 */
public class ParenthesisBalanced {
    
    public static void main(String[] args) {
        System.out.println(isParenthesisBalanced(")"));
        System.out.println(isParenthesisBalanced("())"));
        System.out.println(isParenthesisBalanced("()"));
        System.out.println(isParenthesisBalanced("(((())()))"));
        System.out.println(isParenthesisBalanced("(()("));
    }
    
    private static boolean isParenthesisBalanced(String parentheses) {
        int n = parentheses.length();
        if (n % 2 != 0 || parentheses.charAt(0) == ')') {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(parentheses.charAt(0));
        for (int i = 1; i <= n - 1; i++) {
            if (parentheses.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            else if(parentheses.charAt(i) == '(') {
                stack.push('(');
            }
        }
        return stack.isEmpty();
    }
}
