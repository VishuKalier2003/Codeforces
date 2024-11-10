package Round966_Div3;

import java.util.*;

public class PrimaryTask {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Input Area...
        int t = sc.nextInt();
        int nums[] = new int[t];
        for(int i = 0; i < t; i++)
            nums[i] = sc.nextInt();
        // Output loop...
        for(int i = 0; i < t; i++)
            System.out.println(importantNumber(nums[i]) ? "YES" : "NO");
        sc.close();
    }

    // Convert number to String and then check for conditions...
    public static boolean importantNumber(int num) {
        if(num <= 10)   return false;       // If number is less than 10...
        String s = String.valueOf(num);
        if(!s.substring(0, 2).equals("10")) return false;   // If not a power of 10...
        // If a three digit number with power 0 or 1...
        if(s.length() == 3 && (s.charAt(2) == '1' || s.charAt(2) == '0'))    return false;
        // If the power starts with a 0...
        if(s.length() > 3 && s.charAt(2) == '0')    return false;
        return true;
    }
}
