import java.util.*;

public class C_Gorilla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int n[] = new int[t], m[] = new int[t], k[] = new int[t];
        for(int i = 0; i < t; i++) {
            String s = sc.nextLine();
            n[i] = Integer.parseInt(s.split(" ")[0]);
            m[i] = Integer.parseInt(s.split(" ")[1]);
            k[i] = Integer.parseInt(s.split(" ")[2]);
        }
        for(int i = 0; i < t; i++)
            System.out.println(generatePermutation(n[i], m[i], k[i]));
        sc.close();
    }

    public static String generatePermutation(int n, int m, int k) {
        int nums[] = new int[n];
        Set<Integer> notIncluded = new HashSet<Integer>();
        for(int i = 1; i <= n; i++)
            notIncluded.add(i);
        int max = n, min = m;
        for(int i = 0; i <= n-k; i++) {
            nums[i] = max-i;
            notIncluded.remove(nums[i]);
        }
        for(int j = n-1; j >= n-m; j--) {
            nums[j] = min--;
            notIncluded.remove(nums[j]);
        }
        Iterator<Integer> iterator = notIncluded.iterator();
        for(int i = n-k+1; i < n; i++) {
            if(iterator.hasNext())
                nums[i] = iterator.next();
        }
        return convertToString(nums);
    }

    public static String convertToString(int nums[]) {
        StringBuilder sb = new StringBuilder();
        for(int num : nums)
            sb.append(""+num+" ");
        return sb.toString().trim();
    }
}
