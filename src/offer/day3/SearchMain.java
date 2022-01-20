package offer.day3;

import java.util.HashMap;

public class SearchMain {
    /**
     * 704. 二分查找
     *
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * @param args
     */
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target)){
                return map.get(target);
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<r){
            int num = nums[(l+r)/2];
            if (num>target){
                r--;
            }else if (num<target){
                l++;
            }else {
                return (l+r)/2;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int middle = l+(r-l)/2;
            if (nums[middle]>target){
                l=middle+1;
            }else if (nums[middle]<target){
                r=middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}
