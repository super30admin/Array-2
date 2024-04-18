//3 approaches:
public class FindNumbersDisappearedLC448 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    // Using Hashset
    public List<Integer> findDisappearedNumbersUsingHashSet(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);// add all elements to hashset
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {// iterate and see if 1 to n is present in hashset or not.
                result.add(i);// if not present, add it to list
            }
        }
        return result;
    }

    // Using array
    // No extra space
    // Time complexity : O(n)
    public List<Integer> findDisappearedNumbersUsingArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int val : nums) {
            arr[val] = val;// setting corresponding index of arr[val] to val; if not val is set means that
                           // index will be 0.
            // here arr[5] = 0; & arr[6] =0; arr[1] =1;arr[2] =2 etc
        }
        for (int i = 1; i <= nums.length; i++) {
            if (arr[i] == 0) {// if arr[i] is 0 means element is not present
                result.add(i);// get the element and add it to list
            }

        }
        return result;

    }

    // S30 logic
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // Replace Based on the num encountered Mark the corresponding index as visited
        // by
        // making it negative
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }
        System.out.println("-----" + Arrays.toString(nums));// [-4, -3, -2, -7, 8, 2, -3, -1] ->index of 8 and 2 are 4,5

        // Iterate the array and see if any positive numbers present.
        // if present then add it to list.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);// use index to reproduce number
            }
        }

        return result;
    }
}