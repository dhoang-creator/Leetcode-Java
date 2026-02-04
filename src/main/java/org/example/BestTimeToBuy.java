import java.util.HashMap;
import java.util.Map;

// the below is your nativist approach to the problem and the right one is the one further below
// class BestTimeToBuy {
//     public int maxProfit(int[] prices) {
//         int maxProfit = Integer.MIN_VALUE;
//         int left = 0;
//         int k = prices.length;

//         for (int i = 0; i < k; i++) {
//             if () {
//                 left++;
//             }
//         }
//     }
// }

class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        // you thought maxProfit should be MIN_VALUE but you can buy purchase a stock at a negative price, need to think about constraints
        int maxProfit = 0;

        for (int price : prices) {
            // Update the best buying price
            if (price < minPrice) {
                minPrice = price;
            } else {
                // Try selling today
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
