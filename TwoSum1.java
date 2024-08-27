/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
        public int[] twoSum(int[] nums, int target) {
            // create a map to store num as key and index as value
            HashMap<Integer, Integer> map = new HashMap<>();
            // loop through the integer array, check if the difference existed in the map, return the index
            // otherwise, add num key and index as value to the map
            for (int i = 0; i < nums.length; i++){
                int difference = target - nums[i];

                if(map.containsKey(difference)) {
                    return new int[]{i, map.get(difference)};
                }
                map.put(nums[i], i);
            }

            return new int[]{};
        }
}

/* ## KEY POINT ##
One object is used as a key (index) to another object (value). 
It can store different types: String keys and Integer values, or the same type, like: String keys and String values:

HashMap<String, String> map = new HashMap<String, String>();
- Add an item: map.put("String", "String")
- Access an item: map.get("key")
- Remove an item: map.remove("key")
- Remove all items: map.clear()
- Get the size of HashMap: map.size()
- Loop through the HashMap -- Use the keySet() method if you only want the keys,
        and use the values() method if you only want the values:
// Print keys
for (String i : capitalCities.keySet()) {
  System.out.println(i);
} 

// Print values
for (String i : capitalCities.values()) {
  System.out.println(i);
}

*/





class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int difference = target - num;

            // if the diff in the map, return the indexes
            if (newMap.containsKey(difference)){
                // put newMap.get(difference) at first as putting the smaller index first
                // newMap.get(difference) returns the index of difference and i is the index of the num
                return new int[]{newMap.get(difference), i};
            }
            newMap.put(num, i);
        }
        return new int[] {};

    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i ++){
            for ( int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
