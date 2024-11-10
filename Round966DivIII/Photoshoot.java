package Round966_Div3;

import java.util.*;

public class Photoshoot {
    public static class Gorilla {
        int n, m, k, w;
        long heights[];

        public Gorilla(String s) {
            String str[] = s.split(" ");
            this.n = Integer.parseInt(str[0]);
            this.m = Integer.parseInt(str[1]);
            this.k = Integer.parseInt(str[2]);
        }

        public void updateHeights(int w) {
            this.w = w;
            this.heights = new long[w];
        }

        public void updateHeightsArray(String s) {
            String str[] = s.split(" ");
            for(int i = 0; i < w; i++)
                heights[i] = Long.parseLong(str[i]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Gorilla gorillas[] = new Gorilla[t];
        for(int i = 0; i < t; i++) {
            gorillas[i] = new Gorilla(sc.nextLine());
            gorillas[i].updateHeights(sc.nextInt());
            sc.nextLine();
            gorillas[i].updateHeightsArray(sc.nextLine());
        }
        for(Gorilla gorilla : gorillas)
            System.out.println(maximumSpectacle(gorilla.n, gorilla.m, gorilla.k, gorilla.heights));
        sc.close();
    }

    public static long maximumSpectacle(int n, int m, int k, long heights[]) {
        long spectacle = 0;
        PriorityQueue<Long> cells = fillTheSubmatrices(n, m, k);
        PriorityQueue<Long> gorilla = new PriorityQueue<Long>(Comparator.reverseOrder());
        for(long height : heights)
            gorilla.add(height);
        while(!gorilla.isEmpty())
            spectacle += (gorilla.poll() * cells.poll());
        return spectacle;
    }

    public static PriorityQueue<Long> fillTheSubmatrices(int n, int m, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                int minRow = Math.max(0, i-k+1);
                int maxRow = Math.min(n-k, i);
                int minCol = Math.max(0, j-k+1);
                int maxCol = Math.min(m-k, j);
                maxHeap.add((long)((maxRow-minRow+1) * (maxCol-minCol+1)));
            }
        return maxHeap;
    }
}
