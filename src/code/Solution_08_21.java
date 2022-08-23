package code;

public class Solution_08_21 {

    public static void main(String[] args) {

    }

    /**
     * 输入：sentence = "i love eating burger", searchWord = "burg"
     * 输出：4
     * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
     *
     */
    public int isPrefixOfWord(String sentence , String searchWord){

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

}
