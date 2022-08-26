package code;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 *
 * 示例 1：
 *
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 */
public class Solution_08_11 {

    public static void main(String[] args) {

    }

    public String reformat(String s) {

        Deque<Character> words=new ArrayDeque<>(),nums=new ArrayDeque<>();
        for (Character val :
                s.toCharArray()) {
            if (Character.isDigit(val)){
                nums.add(val);
            }else {
                words.add(val);
            }
        }
        if(Math.abs(words.size()-nums.size())>1) return "";
        String ans="";
        if(words.size()>nums.size()){
            ans=getString(words,nums);
        }else{
            ans=getString(nums,words);
        }
        return ans;
    }

    public String getString(Deque<Character> deque1,Deque<Character> deque2){
        StringBuffer sb = new StringBuffer();
        while (!deque2.isEmpty()){
            sb.append(deque1.pollFirst());
            sb.append(deque2.pollFirst());
        }
        if(!deque1.isEmpty()) sb.append(deque1.pollFirst());
        return sb.toString();
    }
}
