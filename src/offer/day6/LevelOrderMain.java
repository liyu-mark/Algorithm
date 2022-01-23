package offer.day6;

/*

  面试题32 - I. 从上到下打印二叉树
 
  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 
  例如:
  给定二叉树: [3,9,20,null,null,15,7],
 
      3
     / \
    9  20
      /  \
     15   7
 
  返回：
 
  [3,9,20,15,7]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderMain {

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            ans.add(poll.val);
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
