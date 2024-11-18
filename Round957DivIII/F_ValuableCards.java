import java.util.*;

public class F_ValuableCards {
    public class Cards {
        int n, x;
        int nums[];

        public Cards(String str) {
            String s[] = str.split(" ");
            this.n = Integer.parseInt(s[0]);
            this.x = Integer.parseInt(s[1]);
            this.nums = new int[this.n];
        }

        public void updateNums(String str) {
            String s[] = str.split(" ");
            for(int i = 0; i < this.n; i++)
                this.nums[i] = Integer.parseInt(s[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        F_ValuableCards object = new F_ValuableCards();
        Cards cards[] = new Cards[t];
        for(int i = 0; i < t; i++) {
            cards[i] = object.new Cards(sc.nextLine());
            cards[i].updateNums(sc.nextLine());
        }
        sc.close();
        for(Cards card : cards)
            System.out.println(object.minBadSubarrays(card.n, card.x, card.nums));
    }

    SortedSet<Integer> possibleFactors;
    public int minBadSubarrays(int n, int x, int nums[]) {
        possibleFactors = new TreeSet<Integer>();
        int badCount = 0;
        for(int i = 0; i < n; i++)
            if(x % nums[i] == 0) {
                if(isNumberFactored(nums[i], x, possibleFactors))
                    badCount++;
            }
        return badCount+1;
    }

    public boolean isNumberFactored(int num, int x, Set<Integer> possibleFactors) {
        List<Integer> factorList = new ArrayList<Integer>(possibleFactors);
        for(int factor : factorList)
            if(factor * num == x) {
                possibleFactors.add(num);
                return true;
            }
        for(int factor : factorList)
            possibleFactors.add(factor * num);
        possibleFactors.add(num);
        return false;
    }
}
