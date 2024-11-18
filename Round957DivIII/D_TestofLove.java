import java.util.*;

public class D_TestofLove {
    public class LoveTest {
        int n, m, k;
        String segments;

        public LoveTest(String str) {
            String s[] = str.split(" ");
            this.n = Integer.parseInt(s[0]);
            this.m = Integer.parseInt(s[1]);
            this.k = Integer.parseInt(s[2]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        D_TestofLove object = new D_TestofLove();
        LoveTest tests[] = new LoveTest[t];
        for(int i = 0; i < t; i++) {
            tests[i] = object.new LoveTest(sc.nextLine());
            tests[i].segments = sc.nextLine();
        }
        for(LoveTest test : tests)
            System.out.println(willLovePrevail(test.n, test.m, test.k, test.segments) ? "YES" : "NO");
        sc.close();
    }

    public static boolean willLovePrevail(int n, int m, int k, String segments) {
        List<Integer> logs = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            if(segments.charAt(i) == 'L')
                logs.add(i);
        logs.add(n+1);
        int i = -1, nextLog = 0;
        while(i < n-1) {
            if(m >= logs.get(nextLog) - i)
                i = logs.get(nextLog);
            else {
                i += m;
                if(i > n-1)
                    return true;
                while(i < n && i < logs.get(nextLog)) {
                    if(segments.charAt(i) != 'C' && k > 0) {
                        i++; k--;
                    }
                    else
                        return false;
                }
            }
            nextLog++;
        }
        return true;
    }
}
