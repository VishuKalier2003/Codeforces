import java.util.Scanner;

public class A_OnlyPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int a[] = new int[t], b[] = new int[t], c[] = new int[t];
        for(int i = 0; i < t; i++) {
            String s = sc.nextLine();
            a[i] = Integer.parseInt(s.split(" ")[0]);
            b[i] = Integer.parseInt(s.split(" ")[1]);
            c[i] = Integer.parseInt(s.split(" ")[2]);
        }
        for(int i = 0; i < t; i++)
            System.out.println(maxProduct(a[i], b[i], c[i]));
        sc.close();
    }

    public static int maxProduct(int a, int b, int c) {
        return helper(a, b, c, 0);
    }

    public static int helper(int a, int b, int c, int k) {
        if(k == 5)
            return a * b * c;
        int aInc = helper(a+1, b, c, k+1);
        int bInc = helper(a, b+1, c, k+1);
        int cInc = helper(a, b, c+1, k+1);
        return Math.max(aInc, Math.max(bInc, cInc));
    }
}
