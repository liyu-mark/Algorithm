package code;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Stack;

public class Solution_09_02 {

    public static void main(String[] args) {

        Solution_09_02 code = new Solution_09_02();
        int[] ints = code
                .nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4,2});
    }

    /**
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        for (Integer key : map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
        return null;
    }

}
