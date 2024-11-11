package Round964_Div4;

import java.util.*;

public class CardGame {
    public static class Games {     // Storing input for each testcase...
        int a1, a2, b1, b2;

        public Games(String s) {    // Splitting the input line...
            String str[] = s.split(" ");
            this.a1 = Integer.parseInt(str[0]);
            this.a2 = Integer.parseInt(str[1]);
            this.b1 = Integer.parseInt(str[2]);
            this.b2 = Integer.parseInt(str[3]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Input area...
        int t = sc.nextInt();
        Games games[] = new Games[t];
        sc.nextLine();
        for(int i = 0; i < t; i++)
            games[i] = new Games(sc.nextLine());
        // Output area...
        for(Games game : games)
            System.out.println(wayToSuneetWin(game.a1, game.a2, game.b1, game.b2));
        sc.close();
    }

    public static int wayToSuneetWin(int a1, int a2, int b1, int b2) {
        int wins = 0;       // Counting the wins for Suneet...
        if((a1 > b1 && a2 >= b2) || (a1 >= b1 && a2 > b2))  wins += 2;  // Two cases...
        if((a1 > b2 && a2 >= b1) || (a1 >= b2 && a2 > b1))  wins += 2;  // Next two cases...
        return wins;
    }
}
