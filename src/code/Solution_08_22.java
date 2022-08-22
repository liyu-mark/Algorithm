package code;

import offer.day7.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_08_22 {
    /**
     *
     *
     * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。
     * 构造此格式化布局矩阵需要遵循以下规则：
     *
     *     树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
     *     矩阵的列数 n 应该等于 2height+1 - 1 。
     *     根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
     *     对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，
     *     右子节点放置在 res[r+1][c+2height-r-1] 。
     *     继续这一过程，直到树中的所有节点都妥善放置。
     *     任意空单元格都应该包含空字符串 "" 。
     *
     * 返回构造得到的矩阵 res 。
     *
     * @param args
     */

    public static void main(String[] args) {
        //输入：root = [1,2,3,null,4]
//        TreeNode tree = TreeUtils.createTree(0, new int[]{1, 2, 3, -1, 4});
//        System.out.println(TreeUtils.getHeight(tree));
//        System.out.println(printTree(tree));
    }

    public static List<List<String>> printTree(TreeNode root) {
        //树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
        //矩阵的列数 n 应该等于 2height+1 - 1 。
        int height = getHeight(root) - 1;
        int m = height + 1;
        int n = (int) Math.pow(2,height+1) - 1;
        TreeNode[][] ans = new TreeNode[m][n];
        ans[0][(n-1)/2] = root;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TreeNode target = ans[i][j];
                if (target != null){
                    //[r][c] 左 res[r+1][c-2height-r-1] ，右 res[r+1][c+2height-r-1] 。
                    int r = i,c = j;
                    int left_index =  (int)(c - Math.pow(2,height-r-1));
                    int right_index =  (int)(c + Math.pow(2,height-r-1));

                    if (r+1 < m && left_index >= 0 && left_index < n && right_index >= 0 && right_index < n){
                        ans[r+1][left_index] = target.left;
                        ans[r+1][right_index] = target.right;
                    }
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<String> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                strings.add(ans[i][j]==null?"":ans[i][j].val+"");
            }
            res.add(strings);
        }

        return res;
    }

    public static int getHeight(TreeNode root){
        if (root == null) return 0;
        return Math.max(getHeight(root.left)+1,getHeight(root.right)+1);
    }

}
