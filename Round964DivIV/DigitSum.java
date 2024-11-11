package Round964_Div4;

import java.util.*;

public class DigitSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Input area...
        int t = sc.nextInt();
        int nums[] = new int[t];
        for(int i = 0; i < t; i++)
            nums[i] = sc.nextInt();
        // Output area...
        for(int num : nums)
            System.out.println(sumOfTwo(num));
        sc.close();
    }

    public static int sumOfTwo(int n) {
        return (n % 10) + ((n/10) % 10);    // Sum of two-digit numbers...
    }
}
