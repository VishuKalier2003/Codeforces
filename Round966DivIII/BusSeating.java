package Round966_Div3;

import java.util.*;

public class BusSeating {
    public static class Seating {
        int n;
        int nums[];

        public Seating(int n) {
            this.n = n;
            this.nums = new int[n];
        }

        public void assignSeats(String s) {
            String str[] = s.split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(str[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Seating seatings[] = new Seating[t];
        for(int i = 0; i < t; i++) {
            seatings[i] = new Seating(sc.nextInt());
            sc.nextLine();
            seatings[i].assignSeats(sc.nextLine());
        }
        for(Seating seating : seatings)
            System.out.println(busProtocol(seating.nums, seating.n) ? "YES" : "NO");
        sc.close();
    }

    public static boolean busProtocol(int seats[], int n) {
        boolean seated[] = new boolean[n];  // boolean array to mark seats...
        boolean first = true;       // First boarder can sit anywhere...
        for(int seat : seats) {
            seat = seat-1;  // indexing...
            if(first) {
                seated[seat] = true;
                first = false;  // first boarder seated...
            }
            else {
                seated[seat] = true;
                // Check conditions if not satisfied, then there is violation of rules...
                if(seat == 0 && !seated[seat+1])  return false;
                else if(seat == n-1 && !seated[seat-1]) return false;
                else if(seat != 0 && seat != n-1 && !seated[seat-1] && !seated[seat+1]) return false;
            }
        }
        return true;    // If all boarders are seated...
    }
}
