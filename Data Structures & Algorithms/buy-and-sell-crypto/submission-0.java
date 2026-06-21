class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitMade = 0;
        int min_buy = Integer.MAX_VALUE;
        for (int price : prices) {
            min_buy = Math.min(min_buy, price);
            maxProfitMade = Math.max(maxProfitMade, price - min_buy);
        }
        return maxProfitMade;
    }
}
