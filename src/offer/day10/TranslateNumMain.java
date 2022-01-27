package offer.day10;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNumMain {

    public static void main(String[] args) {
        TranslateNumMain main = new TranslateNumMain();
        System.out.println(main.translateNum(12258));
        /**
         * 设
         * X1X2X3...X(i-2) == f(i-2)种翻译
         * X1X2X3...X(i-2)X(i-1) == f(i-1)种翻译
         * X1X2X3...X(i-2)X(i-1)X(i)  如果X(i-1)X(i)可以看作一起翻译 f(i-2) 如果X(i-1)X(i)不能看作一起翻译  f(i-1)
         * 所以
         * f(i) == f(i-1)+f(i-2) || f(i-1)
         *
         */
    }

    public int translateNum(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int[] dp = new int[array.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= array.length; i++) {
            int n = (array[i-2]-'0')*10+(array[i-1]-'0');
            if (n>=10 && n<=25){
                dp[i] = dp[i-1]+dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[array.length];
    }
}
