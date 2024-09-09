/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
*/


class Solution {
    public int search(int[] nums, int target) {
        // binary search: used to find the position of a target value within a sorted
        // array. Repeatedly diving the search interval in half until the target value
        // or the interval is empty. 

        /*
        Input: nums = [-1,0,2,4,6,8], target = 4

        Output: 3
        [-1,0,2,4,6,8]
          l         r --> mid 
              mid

        */
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2; // instead of using (r-l) / 2 because l+(r-l)/2 is safer because it prevents overflow in edge cases with large l and r values.
            /*
            r - l: This calculates the difference between r and l, which gives the distance 
            between the two indices. This avoids adding two large numbers.
            (r - l) / 2: This gives half of the distance between l and r, which is essentially 
            the middle point relative to l.
            l + (r - l) / 2: Finally, adding l to the result shifts the middle point back to 
            the correct position in the array or range.
            */
            if(nums[mid] > target) {
                r = mid - 1;
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

