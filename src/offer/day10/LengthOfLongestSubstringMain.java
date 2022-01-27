package offer.day10;

import java.util.HashMap;

public class LengthOfLongestSubstringMain {

    public static void main(String[] args) {
        String s = "abc";
        // a b c ab bc abc 3*4/2=6
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                System.out.println(s.substring(i, j+1));
            }
        }
    }

    public int lengthOfLongestSubstring(String s) {
        return 0;
    }
}
