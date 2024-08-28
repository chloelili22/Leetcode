/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/


class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
      
       /* 
         The java.lang.Character.isLetterOrDigit(char ch) is an inbuilt method in java which determines 
         if the specified character is a letter or digit. 
       */

        // using l pointer points to the left first string and r pointer points to the last char of the string
       int l = 0; 
       int r = s.length() - 1;
       // loop thru l and r until they meet
       while(l < r) {
        // increment l if the pointer points to a non-igit/char
        while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
            l+=1; // equals l++
        }
        // decrement r if the pointer points to a non-digit/char
        while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
            r-=1; // equals r--
        }

        // if both pointers point to l and r are same, return true
        if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
            return false;
        }
        l++;
        r--;
       }
       return true;
    }






class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        // remove all non-alphanumeric characters and change all to lowercase
      /*
      Since the alphanumeric characters lie in the ASCII value range of [65, 90] for uppercase alphabets, 
      [97, 122] for lowercase alphabets, and [48, 57] for digits.

      replace the given string with empty string except the pattern "[^a-zA-Z0-9]"
      */
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // loop thru the array and check left half and right half elements in the array
        for(int i = 0, j = s.length()-1; i <= s.length()/2; i++, j--){
            // check if there are two diffferent elements, return false.
            // we cannot check if it was equal and return true sice we need to check all elements 
            if(j >= s.length()/2 && s.charAt(i) != s.charAt(j)){
                return false;
            }
        
        }
        return true;
    }
}
