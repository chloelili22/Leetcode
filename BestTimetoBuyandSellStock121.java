/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

class Solution {
    public int maxProfit(int[] prices) {
        // set the first element as minPricee
        int minPrice = prices[0], maxProfit = 0;

        // loop thru the array and compare the minPrice with each element 
        // start i from the second index
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }
}



class Solution {
    public int maxProfit(int[] prices) {
        // using two pointers left and right, left is buy, right is sell
        int l = 0;
        int r = 1;
        int maxP = 0;
        // if right is greater than left, compare the max and the difference between right and left
        // if left is greater than right, left should be shifted to the position of right
        // we want the buy is at the lowest point

        while(r < prices.length){
            if(prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            }
            else{
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
