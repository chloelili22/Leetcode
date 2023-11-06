import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // sort the array from the smallesr to the greatest
        Arrays.sort(strs);

        // set the smallest String and the greatest String to compare the first and the last string
        String smallestStr = strs[0];
        String greatestStr = strs[strs.length - 1];
        String result = "";

        // loop through the smallest string and check with the common prefix in the greatest string. If there is no common prefix, break or return ""
        for(int i = 0; i < smallestStr.length(); i++) {
            if(smallestStr.charAt(i) == greatestStr.charAt(i)){
                result += smallestStr.charAt(i);
            }
            else{
                break;
            }
        }
        return result;
    }
}
