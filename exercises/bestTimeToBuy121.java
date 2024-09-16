
public class bestTimeToBuy121 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var res = sol.maxProfit(new int[] {7, 5, 4, 2, 1});
        // out.printf("The result is %d %n", res);
    }
}

class Solution_121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            profit = (price - buyPrice) > profit ? (price - buyPrice) : profit;
            buyPrice = price < buyPrice ? price : buyPrice;
        }
        return profit;
    }
}

