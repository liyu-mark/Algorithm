package code;

import java.util.*;

/**
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 words[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * 示例 1：
 *
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 *
 */
public class Solution_08_06 {

    public static void main(String[] args) {
        String[] ans = new String[]{"mass","as","hero","superhero"};
        Solution_08_06 main = new Solution_08_06();
        List<String> matching = main.stringMatching(ans);

        for (String val : matching) {
            System.out.println(val);
        }
    }

    public List<String> stringMatching(String[] words) {

        ArrayList<String> ans = new ArrayList<>();

        //words = ["mass","as","hero","superhero"]
        List<String> wordsList = Arrays.asList(words);
        Collections.sort(wordsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //o1 current  o2
                int length_o1 = o1.length();
                int length_o2 = o2.length();
                return length_o1 - length_o2;
            }
        });

        for (int i = 0; i < wordsList.size(); i++) {
            String first = wordsList.get(i);
            for (int j = i; j < wordsList.size(); j++) {
                String second = wordsList.get(j);
                if (second.length() > first.length() && second.contains(first)){
                    ans.add(first);
                }
            }
        }

        return ans;

    }

}
