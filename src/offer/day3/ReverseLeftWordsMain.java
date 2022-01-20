package offer.day3;

public class ReverseLeftWordsMain {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     *
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * 示例 1：
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * 示例 2：
     *
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     * @param args
     */
    public static void main(String[] args) {
        ReverseLeftWordsMain main = new ReverseLeftWordsMain();
        System.out.println(main.reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        char[] res = new char[s.length()];
        int index = 0;
        int pre = n;
        while (n<s.length()){
            res[index++] = s.charAt(n++);
        }
        int i = 0;
        while (i<pre){
            res[index++] = s.charAt(i++);
        }
        return new String(res);
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < s.length()+n; i++) {
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }

}
