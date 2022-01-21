package offer.day4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumberMain {

    public static void main(String[] args) {
        FindRepeatNumberMain main = new FindRepeatNumberMain();
        System.out.println(main.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i]) > 1){
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

}
