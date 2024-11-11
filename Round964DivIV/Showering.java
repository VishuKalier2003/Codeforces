package Round964_Div4;

import java.util.*;

public class Showering {
    public static class Interval {
        int n;
        long s, m;
        long intervals[][];

        public Interval(String s) {
            String str[] = s.split(" ");
            this.n = Integer.parseInt(str[0]);
            this.s = Long.parseLong(str[1]);
            this.m = Long.parseLong(str[2]);
            this.intervals = new long[n][2];
        }

        public void updateInterval(int idx, long l, long r) {
            this.intervals[idx][0] = l;
            this.intervals[idx][1] = r;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Interval intervalInput[] = new Interval[t];
        for(int i = 0; i < t; i++) {
            intervalInput[i] = new Interval(sc.nextLine());
            for(int j = 0; j < intervalInput[i].n; j++) {
                String s = sc.nextLine();
                intervalInput[i].updateInterval(j, Long.parseLong(s.split(" ")[0]), Long.parseLong(s.split(" ")[1]));
            }
        }
        for(Interval interval : intervalInput)
            System.out.println(canAlexShower(interval.n, interval.s, interval.m, interval.intervals) ? "YES" : "NO");
        sc.close();
    }

    public static boolean canAlexShower(int n, long shower, long last, long works[][]) {
        if(works[0][0] >= shower || last-works[n-1][1] >= shower)
            return true;
        for(int i = 1; i < n; i++)
            if(works[i][0] - works[i-1][1] >= shower)
                return true;
        return false;
    }
}
