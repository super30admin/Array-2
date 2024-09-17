/**
 * Q. Given an array of numbers of length N, find both the minimum and maximum.
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 * 
 * Approach 1(Simple) - iterate the array and keep track of min and max elemets
 * using two variables. For each number we make two comparision hence total
 * number of comparision is 2n.
 * 
 * Time Complexity - O(n) 
 * Space Complexity - O(1)
 * 
 * Approach 2(Divide and conquer approach) - Keep on dividing the array
 * recursively until we have two or one element. Compare the elements and find
 * min and max. Now like merge sort instead of combining the two left and right
 * side of partition, we compare their min and max. 
 * 
 * Time Complexity - O(n) 
 * Space Complexity - O(1)
 * 
 */

class Main {
    //Simple approach start
    private static int[] simpleSolution(int[] input) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : input) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        return new int[] { min, max };
    }
    // Simple approach end 

    // Divide and conquer approach start
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;

    private static void getMax(int a, int b) {
        if (a > b) {
            if (a > Max) {
                Max = a;
            }
        } else {
            if (b > Max) {
                Max = b;
            }
        }
    }

    private static void getMin(int a, int b) {
        if (a < b) {
            if (a < Min) {
                Min = a;
            }
        } else {
            if (b < Min) {
                Min = b;
            }
        }
    }

    private static void DivideAndConquer(int[] input, int l, int r) {
        //Keep on dividing until we have less than 2 elements
        if (r - l > 2) {
            int m = (l + r) / 2;
            DivideAndConquer(input, l, m);
            DivideAndConquer(input, m + 1, r);
        } else {
            getMin(input[l], input[r]);
            getMax(input[l], input[r]);
        }
    }
    // Divide and conquer approach end

    public static void main(String[] args) {
        int[] input = { 10 };
        if (input.length == 0)
            System.out.println("Input array empty");

        int[] result = simpleSolution(input);
        System.out.println("Simple Solition");
        for (int num : result) {
            System.out.println(num);
        }

        DivideAndConquer(input, 0, input.length - 1);
        System.out.println("Divide and conquer Solition");
        System.out.println(Max);
        System.out.println(Min);

    }
}
