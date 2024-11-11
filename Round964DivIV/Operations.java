package Round964_Div4;

import java.util.*;

public class Operations {
    int left, right;

    public Operations(String s) {
        String str[] = s.split(" ");
        this.left = Integer.parseInt(str[0]);
        this.right = Integer.parseInt(str[1]);
    }

    public static long dp[];
    public static long prefix[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Operations operations[] = new Operations[t];
        for(int i = 0; i < t; i++)
            operations[i] = new Operations(sc.nextLine());
        evaluateSteps(0,200000);
        for(Operations operation : operations)
            System.out.println(minMoves(operation.left, operation.right));
        sc.close();
    }

    public static void evaluateSteps(int left, int right) {
        Map<Integer, Long> stepMap = new HashMap<>();
        int nums[] = new int[right-left+1];
        for(int i = 0; i < nums.length; i++)
            nums[i] = left + i;
        dp = new long[nums.length];
        prefix = new long[nums.length];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        prefix[0] = 0; prefix[1] = 1; prefix[2] = 2;
        stepMap.put(0, 0l); stepMap.put(1, 1l); stepMap.put(2, 1l);
        for(int i = 3; i < nums.length; i++) {
            int count = 0, value = nums[i]; boolean flag = true;
            while(nums[i] != 0) {
                if(stepMap.containsKey(value)) {
                    dp[i] = count + stepMap.get(value); flag = false;
                    break;
                }
                value = (int)(Math.floor(value/3));
                count++;
            }
            if(flag)    dp[i] = count;
            stepMap.put(i, dp[i]);
            prefix[i] += prefix[i-1]+dp[i];
        }
    }

    public static long minMoves(int left, int right) {
        return 2*dp[left]+prefix[right]-prefix[left];
    }
}
