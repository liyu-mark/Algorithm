package code;

public class Solution_08_09 {

    public static void main(String[] args) {
        Solution_08_09 main = new Solution_08_09();
        System.out.println(main.minStartValue(new int[]{-3, 2, -3, 4, 2}));
    }

    //输入：nums = [-3,2,-3,4,2]
    //输出：5
    public int minStartValue(int[] nums) {
        int k = 1;
        boolean flag = true;

        while (flag){
            boolean postive = false;
            for (int num : nums) {
                if (num + k > 1){
                    postive = true;
                }else {
                    postive = false;
                    break;
                }
            }
            if (postive){
                flag = false;
            }else {
                k++;
            }
        }

        return k;
    }

}
