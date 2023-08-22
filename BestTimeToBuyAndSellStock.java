/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve
*/
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] example1={7,1,5,3,6,4};
        System.out.println(totalProfit(example1)); // Output =7  -We can buy stock on day 2 and sell on day 3 profit will be 4. And again buy on day 3 sell on day 5 profit will be 3. So total profit=7.
        int[] example2={1,2,3,4,5};
        System.out.println(totalProfit(example2)); // 4 buy on day 1 and sell on day 5 profit=4
        int[] example3={7,6,4,3,1};
        System.out.println(totalProfit(example3)); // 0 there is no chance to buy stocks
    }
    //We can buy the stock when there is a low price as compared to next day.
    public static int totalProfit(int[] days){
        int totalProfit=0;
        for(int i=1;i<days.length;i++){ //Start with 2nd day
            int profit=0;
            int buy=days[i];
            if(days[i]>days[i-1]){ // If price is more than previous day find profit.
                profit=days[i]-days[i-1];
                totalProfit +=profit; //Total profit
            }
        }
        return totalProfit;
    }
}
