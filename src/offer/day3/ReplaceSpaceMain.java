package offer.day3;

public class ReplaceSpaceMain {

    /**
     * 剑指 Offer 05. 替换空格
     *
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar==' '){
                sb.append("%20");
            }else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

}
