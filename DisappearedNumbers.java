/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Space Complexity: O(1)
 * Time Complexity: O(n)
 */
public class DisappearedNumbers {
    /**
     * The range is 1 to n, where some appear once, some twice, lets map them to
     * index range that would simply be value less one.
     * 
     * We start iterating over the array, and negate the element at index of abs(currentValue) - 1, if it is not already negated. 
     * This means, all elements present in array contribute to negate the value of corresponding elements at index of its value less one.
     * So eventually the elements that are left untouched(positive), means the corresponding element who was responsible to negate, is it were present, is absent.
     * Value of missing element is the index at which we find positive number plus 1.
     * 
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                continue;
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}