

## Problem Name - Numeric String Template

---

## Problem Description

Kristina has an array `a` consisting of `n` integers and `m` strings. Each string consists only of lowercase Latin letters. She wants to check which strings match the template formed by the array `a`. 

A string `s` is considered to match the template if:
1. The length of `s` is equal to the number of elements in array `a`.
2. The same numbers in `a` must correspond to the same symbols in `s`. 
3. The same symbols in `s` must correspond to the same numbers in `a`.

Thus, there must be a one-to-one correspondence between the elements of the array `a` and the characters of the string `s`.

For each string, output `"YES"` if it matches the template, and `"NO"` otherwise.

**Input:**
- The first line contains an integer `t` (1 ≤ t ≤ 10⁴) — the number of test cases.
- For each test case:
  - The first line contains an integer `n` (1 ≤ n ≤ 2⋅10⁵) — the number of elements in the array `a`.
  - The second line contains `n` integers `a₁, a₂, ..., aₙ` (−10⁹ ≤ aᵢ ≤ 10⁹) — the elements of the array.
  - The third line contains an integer `m` (1 ≤ m ≤ 2⋅10⁵) — the number of strings to check.
  - The next `m` lines contain the strings `sᵢ` (1 ≤ |sᵢ| ≤ 2⋅10⁵) — the strings to check.

**Output:**
For each test case, output `m` lines, each containing `"YES"` if the string matches the template, otherwise `"NO"`.

---

### Test Case Example

**Input:**
```
3
5
3 5 2 1 3
2
abfda
afbfa
2
1 2
3
ab
abc
aa
4
5 -3 5 -3
4
aaaa
bcbc
aba
cbcb
```

**Output:**
```
YES
NO
YES
NO
NO
NO
YES
NO
YES
```

---

### Code Explanation and Segments

---

#### **Class Template**

This class holds the necessary information for each test case, including the array `a`, the number of strings `m`, and the strings to check.

```java
public class Template {
    int n;
    int nums[];
    int m;
    String words[];

    // Constructor to initialize the template with a number n
    public Template(int n) {
        this.n = n;
        this.nums = new int[n];
    }

    // Method to update the numbers array nums from a string input
    public void updateNums(String s) {
        String str[] = s.split(" ");
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(str[i]);
    }

    // Method to initialize the words array with m strings
    public void updateWordsArray(int k) {
        this.m = k;
        this.words = new String[m];
    }

    // Method to update each word in the words array
    public void updateWord(int idx, String word) {
        this.words[idx] = word;
    }
}
```

**Explanation:**
- `Template` class is used to store the details of each test case, including the number array and words to check.
- `updateNums` is used to populate the array `nums` from a space-separated string.
- `updateWordsArray` and `updateWord` are used to store the strings to be checked for matching.

**Time Complexity:**
- Constructing the `Template` object: `O(1)`
- Populating `nums`: `O(n)`
- Populating `words`: `O(m)`

**Space Complexity:**
- `O(n + m)` for storing the numbers and words in each test case.

---

#### **Main Function**

The `main` function reads the input, creates `Template` objects for each test case, and calls the `templateMatching` function to check if the strings match the template.

```java
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    Template templates[] = new Template[t];
    for (int i = 0; i < t; i++) {
        templates[i] = new Template(sc.nextInt());
        sc.nextLine();
        templates[i].updateNums(sc.nextLine());
        templates[i].updateWordsArray(sc.nextInt());
        for (int j = 0; j < templates[i].m; j++)
            templates[i].updateWord(j, sc.next());
    }
    for (Template template : templates)
        templateMatching(template.nums, template.n, template.words, template.m);
    sc.close();
}
```

**Explanation:**
- Reads the input for the number of test cases `t`.
- For each test case, creates a `Template` object, initializes the array `nums`, and stores the strings in `words`.
- Calls the `templateMatching` function for each template to check the words against the template.

**Time Complexity:**
- `O(t)` for reading `t` test cases.
- `O(n + m)` for processing the input and initializing the template objects.

**Space Complexity:**
- `O(t * (n + m))` to store all templates and their corresponding arrays and words.

---

#### **templateMatching Function**

This function checks if each word in the list matches the template.

```java
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
```

**Explanation:**
- For each string in the `words` array:
  - Checks if the length of the word matches the length of the array `a`.
  - Uses two maps (`charToNum` and `numToChar`) to ensure that there is a one-to-one correspondence between characters and array elements.
  - If a violation is found (i.e., the same character corresponds to different numbers or the same number corresponds to different characters), it outputs `"NO"`.
  - If no violations are found, it outputs `"YES"`.

**Time Complexity:**
- `O(n)` for processing each word of length `n` by iterating over each character and using hash map operations (insert and check) which are on average `O(1)`.
- For each test case, the complexity is `O(m * n)` where `m` is the number of words to check.

**Space Complexity:**
- `O(n)` for storing the two hash maps (`charToNum` and `numToChar`) for each word.

---

### **Final Time and Space Complexity**

**Time Complexity:**
- For each test case, the total time complexity is `O(m * n)` where:
  - `m` is the number of strings to check.
  - `n` is the length of each string and the size of the array `a`.
- Thus, the overall time complexity across all test cases is `O(T * (m * n))` where `T` is the number of test cases.

**Space Complexity:**
- The space complexity for each test case is `O(n + m)` to store the numbers and words.
- The total space complexity for all test cases is `O(T * (n + m))` where `T` is the number of test cases.

