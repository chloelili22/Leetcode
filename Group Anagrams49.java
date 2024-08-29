/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hashMap to store key as the count of each char in each string in strs
        HashMap <String, List<String>> res = new HashMap<>();

        // loop thru each string in the string array, and count the number of each char of the string
        // create an array to store the count of 26 char
        // loop thru each char in each string and count the occurances
        for (String i: strs) {
            int[] count = new int[26]; 
            /* 
            The Java string toCharArray() method converts the given string into a sequence of characters. 
            The returned array length is equal to the length of the string. 
            */
            for(char j: i.toCharArray()){
                count[j-'a']++; // j-'a' gets the index of each char from ASCII
            }

            /*
            "abd" -> [1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0 ...] size = 26
            Arrays.toString(count) -> "110100000000..."

            convert the count array to string as the key of hashMap
            key is the occurrence of each char in a string, if two strings have the same occurrence of each char, they can be rearranged
            */
         
            String key = Arrays.toString(count);
         
            // if the occurrence of each char is new, add it(key) and create a empty list to store value in the hashmap
            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            // key is there, add the string into the list as value
            res.get(key).add(i);
        }

        return new ArrayList<>(res.values());
    }
}
