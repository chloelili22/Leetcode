import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // loop through the string and check if the first element is '(', '{', '[', and add it into the stack
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // if not, check if the closisng bracket is empty, return false
            // ")"
            else {
                // the character is a closing bracket without matching bracket, return false
                if(stack.isEmpty()){
                    return false;
                }

                // there are matching characters in the string,
                char lastChar = stack.peek();
                if((c == ')' && lastChar == '(')|| (c == '}' && lastChar == '{') || (c == ']' && lastChar == '[')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }

        return stack.isEmpty();


    }
}
