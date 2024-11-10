package Round966_Div3;

import java.util.*;

public class StringTemplate {
    public static class Template {
        int n;
        int nums[];
        int m;
        String words[];

        public Template(int n) {
            this.n = n;
            this.nums = new int[n];
        }

        public void updateNums(String s) {
            String str[] = s.split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(str[i]);
        }

        public void updateWordsArray(int k) {
            this.m = k;
            this.words = new String[m];
        }

        public void updateWord(int idx, String word) {
            this.words[idx] = word;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Template templates[] = new Template[t];
        for(int i = 0; i < t; i++) {
            templates[i] = new Template(sc.nextInt());
            sc.nextLine();
            templates[i].updateNums(sc.nextLine());
            templates[i].updateWordsArray(sc.nextInt());
            for(int j = 0; j < templates[i].m; j++)
                templates[i].updateWord(j, sc.next());
        }
        for(Template template : templates)
            templateMatching(template.nums, template.n, template.words, template.m);
        sc.close();
    }

    public static void templateMatching(int nums[], int n, String words[], int m) {
        for (String word : words) {
            Map<Character, Integer> charToNum = new HashMap<>();
            Map<Integer, Character> numToChar = new HashMap<>();
            int len = word.length();
            boolean check = false;

            if (n != len) {
                System.out.println("NO");
                continue;
            }

            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int num = nums[i];

                if ((charToNum.containsKey(c) && charToNum.get(c) != num) ||
                    (numToChar.containsKey(num) && numToChar.get(num) != c)) {
                    System.out.println("NO");
                    check = true;
                    break;
                }

                charToNum.putIfAbsent(c, num);
                numToChar.putIfAbsent(num, c);
            }

            if (!check)
                System.out.println("YES");
        }
    }

}
