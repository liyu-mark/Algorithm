package offer.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2Main {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null)queue.add(poll.right);
            }
            ans.add(temp);
        }
        return ans;
    }

}
