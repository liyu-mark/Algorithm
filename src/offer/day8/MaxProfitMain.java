package offer.day8;

import sun.management.jdp.JdpJmxPacket;

public class MaxProfitMain {

    public static void main(String[] args) {

    }

    //暴力
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    //遍历最小值
    public int maxProfit1(int[] prices) {
       int min = prices[0];
       int maxProfit = prices[1]-prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (prices[i]<prices[i-1]){
                min = prices[i];
            }
            if (prices[i]-min>maxProfit){
                maxProfit = prices[i]-min;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length<2) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1],prices[i]-cost);
            cost = Math.min(cost,prices[i]);
        }
        return dp[prices.length-1];
    }


}
