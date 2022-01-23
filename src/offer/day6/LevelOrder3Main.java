package offer.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3Main {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode poll = queue.poll();
                if (ans.size()%2!=0){
                    temp.addFirst(poll.val);
                }else {
                    temp.addLast(poll.val);
                }
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
