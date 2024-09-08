/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occur = new HashMap<Integer, Integer>();
        // list to store the frequency with a size of nums.length + 1 because the maximum possible frequency for any number is the length of nums.
        // freq = [?, ?, ?, ?, ?, ?]
        List<Integer>[] freq = new List[nums.length + 1];

        // initially assign an arrayList into each index of frequency list since we need to return a list
          for(int i = 0 ; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        // count the occurance of the integers in nums list
        //     for (int n : nums) {
        //     count.put(n, count.getOrDefault(n, 0) + 1);
        // }
        // occur = [key1=value1, key2=value2, key3=value3, ...]
        // occur = [1=1, 2=2, 3=3]
        for(int i = 0 ; i < nums.length; i++){
            occur.put(nums[i], occur.getOrDefault(nums[i], 0)+1);
        }
        
        // "freq = [[],  [],   [],  [],    [], []]" + "occur = [1=1, 2=2, 3=3]"
        // freq = [     [1], [2], [3]]
        for (Map.Entry<Integer, Integer> entry : occur.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i > 0 && index < k; i--){
            // get the value of the list in freq
            for(int j: freq[i]){
                result[index++] = j;
                if(index == k){
                    return result;
                }
            }
        }
        return result;
    }
}
