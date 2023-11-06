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
            Map<Integer, Integer> map = new HashMap<>();
            // loop through the integer array, check if the difference existed in the map, return the index
            // otherwise, add num key and index as value to the map
            for (int i = 0; i < nums.length; i++){
                int difference = target - nums[i];

                if(map.containsKey(difference)) {
                    return new int[]{i, map.get(difference)};
                }
                map.put(nums[i], i);
            }

            return null;
        }
}
