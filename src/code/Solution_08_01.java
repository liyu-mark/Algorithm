package code;

public class Solution_08_01 {

    public static void main(String[] args) {

    }

    /**
     * 1374. 生成每种字符都是奇数个的字符串
     *
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     *
     */
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n%2!=0){
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }else {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }
        return sb.toString();

    }


}
