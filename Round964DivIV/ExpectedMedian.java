package Round964_Div4; // Defines the package name for organizational purposes

import java.util.*; // Imports all utility classes from the java.util package

public class ExpectedMedian { // Defines the main class for the program

    // Nested class to represent each test case data
    public static class Data {
        int n, k; // Number of elements and the required size of the subset
        int nums[]; // Array to store the elements of the subset

        // Constructor to initialize `n`, `k` from an input string
        public Data(String s) {
            String str[] = s.split(" "); // Splits the input string by space
            this.n = Integer.parseInt(str[0]); // First part is `n`
            this.k = Integer.parseInt(str[1]); // Second part is `k`
            this.nums = new int[n]; // Initializes the nums array with size `n`
        }

        // Method to populate the `nums` array from a string of numbers
        public void updateNums(String str) {
            String s[] = str.split(" "); // Splits the input string by space
            for(int i = 0; i < this.n; i++) // Iterates over all elements
                this.nums[i] = Integer.parseInt(s[i]); // Parses each element and assigns to nums array
        }
    }

    public static int MOD = 1_000_000_007; // Modulo constant for large numbers
    public static int factorial[]; // Array to store factorial values

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Creates a scanner for input
        int t = sc.nextInt(); // Reads the number of test cases
        sc.nextLine(); // Consumes the newline character after the integer input

        Data testcases[] = new Data[t]; // Array to store all test cases
        for(int i = 0; i < t; i++) { // Loops through all test cases
            testcases[i] = new Data(sc.nextLine()); // Initializes each test case with input
            testcases[i].updateNums(sc.nextLine()); // Populates the nums array for each test case
        }

        factorials(); // Precomputes factorials for combinations
        for(Data testcase : testcases) // Loops through each test case
            System.out.println(findMedianSum(testcase.k, testcase.nums)); // Prints the result for each test case

        sc.close(); // Closes the scanner to free resources
    }

    // Method to calculate the expected median sum based on the problem conditions
    public static int findMedianSum(int k, int nums[]) {
        int oneCount = 0, zeroCount = 0; // Counters for `1`s and `0`s
        for(int num : nums) // Loops through nums array
            oneCount += num == 1 ? 1 : 0; // Counts the number of `1`s
        zeroCount = nums.length - oneCount; // Counts the number of `0`s

        int req = (k / 2) + 1; // Calculates the minimum number of `1`s required for the median
        int totalCount = 0; // Variable to store the total count for combinations
        for (int i = req; i <= Math.min(k, oneCount); i++) { // Loops from required `1`s to the max possible
            totalCount = (totalCount + (int)((long)nCr(oneCount, i) * nCr(zeroCount, k - i) % MOD)) % MOD;
            // Adds the product of nCr for oneCount and zeroCount to totalCount, taking modulo MOD
        }
        return totalCount; // Returns the total count result
    }

    // Method to calculate nCr % MOD using factorials
    public static int nCr(int n, int r) {
        if (r > n) return 0; // Returns 0 if `r` is greater than `n` (invalid combination)
        return moduloDivision(factorial[n], (int)((long)factorial[n - r] * factorial[r] % MOD));
        // Divides factorial[n] by factorial[n - r] * factorial[r] using modular division
    }

    // Method to perform modular division (p / q) % MOD using Fermat's Little Theorem
    public static int moduloDivision(int p, int q) {
        return (int)((long)p * exponentialDivision(q, MOD - 2) % MOD);
        // Multiplies `p` with the modular inverse of `q` modulo MOD
    }

    // Method to perform modular exponentiation (x^n) % MOD
    public static int exponentialDivision(int x, int n) {
        x %= MOD; // Takes x modulo MOD to prevent overflow
        if (n == 0) return 1; // Base case: x^0 = 1
        int p = exponentialDivision((int)((long)x * x % MOD), n / 2);
        // Recursive call for x^2 in half the exponent
        if (n % 2 != 0) // Checks if n is odd
            return (int)((long)p * x % MOD); // Multiplies result by x if `n` is odd
        else
            return p; // Returns result for even `n`
    }

    // Method to precompute factorials modulo MOD
    public static void factorials() {
        factorial = new int[200001]; // Initializes the factorial array with a maximum size of 200001
        factorial[0] = 1; // Sets factorial[0] to 1 as base case
        for (int i = 1; i < factorial.length; i++) // Loops to compute all factorial values
            factorial[i] = (int)((long)factorial[i - 1] * i % MOD); // Stores factorial values modulo MOD
    }
}
