/*
    Problem : Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
    T.C: O(1.5 * n) + 2 - for odd no. elements :: S.C: O(1) - expected to return min and max elements

    Solved using linear traversal: Compare the elements i and i + 1 as pairs
    and then perform a comparision of the greater element with max and smaller
    element with min. Here we are performin a total of 3 comparisions for 
    2 elements. In brute force approach we would have to make 2 comparisions 
    for each element (i.e. 4 comparisions for 2 elements). Therefore for a large
    value n we would make a total of 3 * (n / 2) comparisions which is better than 2n.
*/

public class FindMinMaxElement {
    int min, max;

    public FindMinMaxElement(int size) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void solution(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (i != n - 1 || n % 2 == 0) {
                if (nums[i] < nums[i + 1]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i + 1]);
                } else {
                    min = Math.min(min, nums[i + 1]);
                    max = Math.max(max, nums[i]);
                }
            } else {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            i += 2;
        }
    }

    public static void main(String[] args) {
        FindMinMaxElement obj = new FindMinMaxElement(10);

        int[] array = new int[] {3, 16, -4, 8, 7, -2, 6, 15, 9, 0};

        obj.solution(array);

        System.out.println("The minimum is: " + obj.min);
        System.out.println("The maximum is: " + obj.max);
    }
}