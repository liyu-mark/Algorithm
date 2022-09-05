package code;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），
 * 则位置 (i, j) 被称为特殊位置。
 * 示例 1：
 *
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 */
public class Solution_09_04 {

    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int[] sum_i = new int[mat.length];
        int[] sum_j = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum_i[i] += mat[i][j];
                sum_j[j] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && sum_i[i] == 1 && sum_j[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }

}
