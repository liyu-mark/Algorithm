package offer.day4;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * int left =0,right = nums.length-1;
 *         int count = 0;
 *         while(left<right){
 *             int mid = (left+right)/2;
 *             if(nums[mid]>=target)
 *                 right=mid;
 *             if(nums[mid]<target)
 *                 left = mid+1;
 *         }
 *         while(left<nums.length&&nums[left++]==target)
 *             count++;
 *         return count
 *
 */
public class SearchMain {

    public static void main(String[] args) {
        //输入: nums = [5,7,7,8,8,10], target = 8
        SearchMain main = new SearchMain();
        System.out.println(main.search1(new int[]{1,2,2},1));
    }

    public int search1(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int middle = l+(r-l)/2;
            if (nums[middle]>target){
                r=middle-1;
            }else if (nums[middle]<target){
                l=middle+1;
            }else {
                r=middle-1;
            }
        }

        if (nums[l]!=target){
            return 0;
        }

        int ans = 1;
        while (l<nums.length-1){
            if (nums[l]==nums[l+1]){
                ans++;
                l++;
            }else {
                break;
            }
        }
        return ans;
    }



    public int search(int[] nums, int target) {
        int binarysearch = binarysearch(nums, target);
        if (binarysearch==-1){
            return 0;
        }
        int cnt = 1;
        for (int i = binarysearch; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                cnt++;
            }else {
                break;
            }
        }
        for (int i = binarysearch; i>0; i--) {
            if (nums[i] == nums[i-1]){
                cnt++;
            }else {
                break;
            }
        }
        return cnt;
    }

    public static int binarysearch(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int middle = l+(r-l)/2;
            if (nums[middle]>target){
                r=middle;
            }else if (nums[middle]<target){
                l=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}
