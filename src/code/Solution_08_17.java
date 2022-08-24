package code;

import offer.day7.TreeNode;

import java.util.*;

public class Solution_08_17 {

    public static void main(String[] args) {
        //输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        Solution_08_17 main = new Solution_08_17();
        TreeNode tree = main.createTree(0, new int[]{1, 2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1,-1,-1, 8});
        System.out.println(main.getDeepestSum(tree));
    }

    public int deepestLeavesSum(TreeNode root) {
        int height = depth(root);
        return 0;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    public TreeNode createTree(int index, int[] arr){
        if (index >= arr.length || arr[index] == -1){
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTree(index*2+1,arr);
        root.right = createTree(index*2+2,arr);
        return root;
    }

    public int print(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> objects = new ArrayList<Integer>();
            while (size-->0){
                TreeNode poll = queue.poll();
                objects.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            ans.add(objects);
        }

        int res = 0;
        ArrayList<Integer> last = ans.get(ans.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            res+=last.get(i);
        }
        return res;
    }

    public int getDeepestSum(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> levelArr = new ArrayList<>();
            while (size-- > 0){
                TreeNode poll = queue.poll();
                levelArr.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            levelMap.put(level++,levelArr);
        }

        ArrayList<Integer> list = levelMap.get(level-1);
        int sum = 0;
        for (Integer val:list
             ) {
            sum+=val;
        }
        return sum;
    }

}
