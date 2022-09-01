package code;

import com.sun.media.jfxmediaimpl.HostUtils;

/**
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * 示例 1：
 *
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 */
public class Solution_09_01 {

    public static void main(String[] args) {
        Solution_09_01 code = new Solution_09_01();
        int[] finalPrices = code.finalPrices(new int[]{8, 4, 6, 2, 3});
        for (int val :
                finalPrices) {
            System.out.println(val);
        }
    }

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int cur_price = prices[i];
            int discount = 0;
            boolean flag = false;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= cur_price){
                    discount = cur_price - prices[j];
                    flag = true;
                    break;
                }
            }
            ans[i] = flag?discount:cur_price;
        }
        return ans;
    }

}
