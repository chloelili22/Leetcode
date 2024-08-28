/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/


// using HashMap
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (map.containsKey(num)){
                return true;
            }
            map.put(num, i);
        }
        return false;
        
    }
}


/* using Set: unordered collection of objects in which duplicate values cannot be stored
   Set<String> hs = new HashSet<String>();
   - Adding Elements: hs.add("B");
   - Accessing the Elements: hs.contains("B")
   - Removing the Values: hs.remove("B")
   - Iterating through the Set: for (String value : hs)
                               // Printing all the values inside the object 
                                  System.out.print(value + ", ");   
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }
}
