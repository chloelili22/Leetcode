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


/*
stack: LIFO last in first out -- the last element added to the stack will be the first one to be removed.
stack.empty() -- It returns true if nothing is on the top of the stack. Else, returns false.
stack.peek() -- Returns the element on the top of the stack, but does not remove it.
stack.pop() -- Removes and returns the top element of the stack. An ‘EmptyStackException’. An exception is thrown if we call pop() when the invoking stack is empty.
stack.push() -- Add an element on the top of the stack
stack.search() -- It determines whether an object exists in the stack. If the element is found. It returns the position of the element from the top of the stack. Else, it returns -1.
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
                // the character is a closing bracket without a matching bracket, return false
                if(stack.isEmpty()){
                    return false;
                }

                // remove the open and closed sign if they matched
                char lastChar = stack.peek(); // Last in first out to get the first closing sign
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


// ([]) -- stack: last in first out, stack.pop() can get the fist top object of the stack
// ], } -- cheeck if stack is empty
class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()
             ) {

            if(x=='('){
                
                stack.push(')');
            } else if (x=='{') {
                stack.push('}');
                
            } else if (x=='[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop()!=x) {

                return false;
            }


        }


        return stack.isEmpty();
        
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> bracketLookup = new HashMap<>(3);

        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bracketLookup.containsKey(c)) {
                if (!brackets.isEmpty() && bracketLookup.get(c).equals(brackets.peek())) {
                    brackets.pop();
                } else {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }

        return brackets.isEmpty();
    }
}

