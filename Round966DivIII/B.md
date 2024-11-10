
### Problem Name: Seating in a Bus

---

### Problem Description

In Berland, a bus consists of a row of `n` seats numbered from `1` to `n`. Passengers are advised to board the bus following these rules:

1. If there are no occupied seats in the bus, a passenger can sit in any free seat.
2. Otherwise, a passenger should sit in any free seat that has at least one occupied neighboring seat. Specifically, a passenger can sit in a seat with index `i` (`1 ≤ i ≤ n`) only if at least one of the seats with indices `i-1` or `i+1` is occupied.

Given an array `a` representing the chronological order of seats occupied by the passengers, determine if all passengers followed the recommendations.

**Example:**  
If `n = 5` and `a = [5, 4, 2, 1, 3]`, the passengers did **not** follow the recommendations because the 3rd passenger sat in seat `2`, while seats `1` and `3` were both free.

---

### Input Format

1. The first line contains a single integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
2. For each test case:
   - The first line contains one integer `n` (1 ≤ n ≤ 2⋅10^5) — the number of seats and passengers.
   - The second line contains `n` distinct integers `a[i]` (1 ≤ a[i] ≤ n) — the seats that passengers occupied in order.

The sum of `n` values across all test cases does not exceed 2⋅10^5, and no passenger sits in an already occupied seat.

---

### Output Format

For each test case, output "YES" if all passengers followed the recommendations, and "NO" otherwise.

**Note**: Case sensitivity in output is flexible (`"yes"`, `"Yes"`, `"YES"` are all acceptable).

---

### Test Case Examples

#### Test Case 1

**Input:**

```
4
5
5 4 2 1 3
3
2 3 1
4
2 3 1 4
5
1 2 3 5 4
```

**Output:**

```
NO
YES
YES
NO
```

---

### Intuition and Observations

1. **Pattern Analysis**:
   - If the first passenger can sit anywhere, we mark that seat as occupied.
   - Subsequent passengers must choose seats adjacent to already occupied seats to ensure compliance.
   - For each subsequent passenger, if they choose a seat with no adjacent occupied seat, the recommendations are violated.

2. **Boolean Array for Occupied Seats**:
   - We use a boolean array `seated` to keep track of occupied seats as each passenger boards.
   - For each new seat selection, we check the neighboring seats (left and right) to determine if there is an occupied neighbor.

3. **Edge Cases**:
   - Seats at the edges (first and last) should be checked carefully since they have only one neighboring seat.
   - Test cases with the smallest `n` (like `n = 1`) should be handled properly to ensure correct initial seating logic.

---

### Code Explanation

The code implements a solution in Java with a main function for input/output handling and a helper function `busProtocol` to validate each boarding sequence.

---

#### Code Explanation: `main` function

```java
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
```

1. **Input Handling**:
   - Reads the integer `t` (number of test cases) and creates an array of `Seating` objects.
   - For each test case, it reads `n` (number of seats) and the list of seat numbers chosen by passengers in chronological order.
   
2. **Processing Each Test Case**:
   - For each `Seating` instance, it calls `busProtocol` to determine if the seating arrangement complies with the rules.
   - Prints `"YES"` or `"NO"` for each test case based on the result.

**Time Complexity:** `O(t * n)`, where `t` is the number of test cases and `n` is the number of seats per test case.

**Space Complexity:** `O(t * n)`, due to storing `n` seats for each test case.

---

#### Code Explanation: `busProtocol` function

```java
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
```

1. **Initial Check for First Passenger**:
   - The first passenger can sit anywhere, so we mark their seat as occupied and continue.

2. **Subsequent Passenger Checks**:
   - For each passenger, we check if their selected seat has an occupied neighboring seat (either left or right).
   - If a seat has no occupied neighbors, the function returns `false` as it violates the boarding rule.

3. **Edge Case Handling**:
   - If a seat is the first or last in the row, it only needs one neighboring seat to be occupied.
   - If all seats are occupied without rule violation, it returns `true`.

**Time Complexity:** `O(n)` per test case, as it iterates through each passenger's seat selection once.

**Space Complexity:** `O(n)`, for the boolean array to track occupied seats.

---

### Overall Complexity

- **Time Complexity of Solution:** `O(t * n)`, where `t` is the number of test cases and `n` is the number of seats in each test case.
- **Space Complexity of Solution:** `O(t * n)`, due to the boolean arrays created for each test case. 
