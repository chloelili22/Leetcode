
/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1

 */
class Solution9 {
    public boolean isPalindrome(int x) {
        // edge cases: x is less than 0, and x can be divided by 10, return false
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        // set the reversed var to 0
        int reversed = 0;

        // split the int to two part and compare two sides of it
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        // left side if x is a num with even digits, right side if x is a num with odd digits
        return (x == reversed) || (x == reversed / 10);
    }
}

/*
x = 898 -> 89 -> 8
r: 0 -> 8 -> 89
*/
