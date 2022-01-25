package contest.contest1;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 */
public class LexicalOrderMain {
    public static void main(String[] args) {
        LexicalOrderMain main = new LexicalOrderMain();
        main.lexicalOrder(13);
    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(i,n);
        }
        return list;
    }
    private void dfs(int i,int n){
        if (i>n) return;
        list.add(i);
        for (int j = 1; j < 10; j++) {
            dfs(i*10+j,n);
        }
    }
}
