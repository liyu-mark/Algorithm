package code;

import java.util.*;

public class Solution_08_25 {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        Collections.sort(nums, new Comparator<Integer>() {
            //o1为当前值 o2为比较值
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs_o1 = Math.abs(o1 - 3);
                int abs_o2 = Math.abs(o2 - 3);
                return abs_o1-abs_o2;
            }
        });

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }


    }

    /**
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer val :
                arr) {
            list.add(val);
        }

        /**
         *  a 比 b更接近x
         * |a - x| < |b - x| 或者
         * |a - x| == |b - x| 且 a < b
         */
        Collections.sort(list,(a,b)->{
            //a为当前值
            int abs_a = Math.abs(a - x);
            int abs_b = Math.abs(b - x);
            if (abs_a<abs_b || (abs_a==abs_b && a<b)){
                return -1;
            }
            return 1;
        });

        List<Integer> subList = list.subList(0, k);
        Collections.sort(subList);
        return subList;
    }


}
