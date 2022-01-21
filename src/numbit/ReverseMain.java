package numbit;

public class ReverseMain {

    public static void main(String[] args) {
        System.out.println(-120%10);
    }

    public int reverse(int x) {
        if (x==0){
            return 0;
        }
        boolean flag = x<0;
        x=Math.abs(x);
        StringBuffer sb = new StringBuffer();
        while (x!=0){
            sb.insert(0,x%10);
            x/=10;
        }
        return flag?-Integer.parseInt(sb.reverse().toString()):Integer.parseInt(sb.reverse().toString());
    }

}
