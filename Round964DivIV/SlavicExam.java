package Round964_Div4;

import java.util.*;

public class SlavicExam {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String stripes[] = new String[t];
        String words[] = new String[t];
        for(int i = 0; i < t; i++) {
            stripes[i] = sc.next();
            words[i] = sc.next();
        }
        for(int i = 0; i < t; i++) {
            String output[] = isSubsequence(stripes[i], words[i]).split(" ");
            if(output[0].equals("NO"))
                System.out.println("NO");
            else {
                System.out.println(output[0]);
                System.out.println(output[1]);
            }
        }
        sc.close();
    }

    public static String isSubsequence(String strip, String word) {
        int i = 0, j = 0;
        int stripLength = strip.length(), wordLength = word.length();
        StringBuilder sb = new StringBuilder();
        while(i != stripLength) {
            char ch = strip.charAt(i);
            if(j != wordLength && ch == '?') {
                sb.append(""+word.charAt(j));
                i++; j++;
            }
            else if(j != wordLength && ch == word.charAt(j) && ch != '?') {
                sb.append(""+word.charAt(j));
                i++; j++;
            }
            else {i++;}
        }
        String formed = sb.toString();
        if(formed.length() != word.length())
            return "NO";
        for(int k = 0; k < stripLength-formed.length(); k++)
            sb.append(""+strip.charAt(formed.length()+k));
        return "YES "+sb.toString().replace('?', 'a');
    }
}
