import java.util.*;

public class B_AngryMonk {
    public class Monk {
        long n;
        int k;
        int nums[];

        public Monk(String s) {
            String str[] = s.split(" ");
            this.n = Long.parseLong(str[0]);
            this.k = Integer.parseInt(str[1]);
            this.nums = new int[this.k];
        }

        public void updateNums(String str) {
            String s[] = str.split(" ");
            for(int i = 0; i < this.nums.length; i++)
                this.nums[i] = Integer.parseInt(s[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        B_AngryMonk object = new B_AngryMonk();
        Monk monks[] = new Monk[t];
        for(int i = 0; i < t; i++) {
            monks[i] = object.new Monk(sc.nextLine());
            monks[i].updateNums(sc.nextLine());
        }
        for(Monk monk : monks)
            System.out.println(makeMonkHappy(monk.nums, monk.k));
        sc.close();
    }

    public static long makeMonkHappy(int nums[], int k) {
        Arrays.sort(nums);
        long c1 = 0;
        for(int i = 0; i < k-1; i++)
            c1 += (nums[i]-1);
        return c1 + (c1 + k-1);
    }
}
