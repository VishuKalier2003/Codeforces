package Round966_Div3;

import java.util.*;

public class RightLeft {
    public static class Data {
        long n;
        String s;
        long nums[];

        public Data(int n) {
            this.n = n;
            this.nums = new long[n];
        }

        public void fillNums(String s) {
            String str[] = s.split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Long.parseLong(str[i]);
        }

        public void fillStrip(String s) {
            this.s = s;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Data nodes[] = new Data[t];
        for(int i = 0; i < t; i++) {
            nodes[i] = new Data(sc.nextInt());
            sc.nextLine();
            nodes[i].fillNums(sc.nextLine());
            nodes[i].fillStrip(sc.next());
        }
        for(Data node : nodes)
            System.out.println(maxStripScore(node.nums, node.s, node.nums.length));
        sc.close();
    }

    public static long maxStripScore(long nums[], String s, int n) {
        long score = 0;
        long left[] = new long[n], right[] = new long[n];
        left[0] = s.charAt(0) == 'L' ? 1 : 0;
        right[n-1] = s.charAt(n-1) == 'R' ? 1 : 0;
        for(int i = 1; i < n; i++)
            left[i] = s.charAt(i) == 'L' ? left[i-1]+1 : left[i-1];
        for(int j = n-2; j > -1; j--)
            right[j] = s.charAt(j) == 'R' ? right[j+1]+1 : right[j+1];
        for(int i = 0; i < n; i++)
            score += (Math.min(left[i], right[i]) * nums[i]);
        return score;
    }
}
