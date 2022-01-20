package offer.day3;

public class SearchInsertMain {

    /**
     * 35. 搜索插入位置
     *
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * @param args
     */
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int middle = l+(r-l)/2;
            if (nums[middle]>target){
                r=middle-1;
            }else if (nums[middle]<target){
                l=middle+1;
            }else {
                return middle;
            }
        }
        return l;
    }

}
