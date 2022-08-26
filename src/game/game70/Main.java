package game.game70;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //输入：cost = [输入：cost = [6,5,7,9,2,2]]
//        System.out.println(minimumCost(new int[]{5,5}));
        //输入：differences = [1,-3,4], lower = 1, upper = 6
        //输入：nums = [-3,3,3,90]
//        System.out.println(countElements(new int[]{11,7,2,15}));
        //输入：nums = [3,1,-2,-5,2,-4]
        //输入：nums = [10,6,5,8]
        List<Integer> lonely = findLonely(new int[]{10,6,5,8});
        for(Integer x : lonely){
            System.out.println(x);
        }
    }

    public static List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
        if (nums.length==0) {ans.add(nums[0]); return ans;}
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])==1){
                if (i==0){
                    if (nums[i+1]-1!=nums[i]){
                        ans.add(nums[i]);
                    }
                }else if (i==nums.length-1){
                    if (nums[i-1]+1!=nums[i]){
                        ans.add(nums[i]);
                    }
                }else {
                    int pre = nums[i-1];
                    int pst = nums[i+1];
                    if (pre+1!=nums[i] && pst-1!=nums[i]){
                        ans.add(nums[i]);
                    }
                }
            }
        }
        return ans;
    }

    public static int countElements(int[] nums) {
        if (nums.length==0) return 0;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=min && nums[i]!=max){
                ans++;
            }
        }
        return ans;
    }
    public static int[] rearrangeArray(int[] nums) {
        int[] pos  = new int[nums.length/2];
        int[] neg  = new int[nums.length/2];
        int j=0,k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                pos[j++]=nums[i];
            }else {
                neg[k++]=nums[i];
            }
        }
        int[] ans = new int[nums.length];
        int posi = 0,negi=0,ansi=0;
        boolean flag = true;
        while (ansi<ans.length){
            if (flag){
                ans[ansi++] = pos[posi++];
                flag = !flag;;
            }else {
                ans[ansi++] = neg[negi++];
                flag = !flag;
            }
        }
        return ans;
    }



    /**
     * 输入：differences = [1,-3,4], lower = 1, upper = 6
     * 输出：2
     *
     * 解释：符合要求的隐藏数组为：
     * - [3, 4, 1, 5]
     * - [4, 5, 2, 6]
     * 所以返回 2 。
     * 4 6
     * 3 5
     * 2 4
     * 1 3
     * 1 2 -1 5
     *
     * dp[0] = 4 dp[1] = dp[0]
     *
     *
     * 输入：differences = [3,-4,5,1,-2], lower = -4, upper = 5
     *
     * dp[0] =
     */
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int sum = 0;
        for (int i = 0; i < differences.length; i++) {
            sum+=differences[i];
        }
        int ans = 0;
        for (int i = lower; i <= upper; i++) {
            if (i+sum<=upper){
                boolean flag = true;
                int first = i;
                for (int j = 0; j < differences.length; j++) {
                    if (first+differences[j]<lower || first+differences[j]>upper){
                        flag = false;
                        break;
                    }
                    first = first+differences[j];
                }
                if (flag){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int minimumCost(int[] cost) {
        int sum = 0;
        if (cost.length<3){
            for (int i = 0; i < cost.length; i++) {
                sum+=cost[i];
            }
            return sum;
        }

        Arrays.sort(cost);
        int j = 0;
        for (int i = cost.length-1; i >= 0; i--) {
            j++;
            if (j%3!=0){
                sum+=cost[i];
            }
        }
        return sum;
    }


}
