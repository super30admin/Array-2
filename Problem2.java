//This is the efficient pair comparison method to find minimum and maximum.
//
//Instead of comparing every element with min and max separately, we:
//Compare elements in pairs
//First compare pair internally
//Then compare with global min and max
//Time: O(n)
//Space: O(1)

public class Problem2 {

    public int[] findMinAndMax(int[] nums) {

        // Length of array
        int n = nums.length;

        // Variables to store minimum and maximum
        int min, max;

        // Index to start processing
        int i;


        // STEP 1: Handle first pair separately

        // If number of elements is EVEN
        if (n % 2 == 0) {

            // Compare first two elements
            if (nums[0] < nums[1]) {

                min = nums[0];
                max = nums[1];

            } else {

                min = nums[1];
                max = nums[0];
            }

            // Start checking from index 2
            i = 2;
        }

        // If number of elements is ODD
        else {

            // Initialize both min and max with first element
            min = nums[0];
            max = nums[0];

            // Start checking from index 1
            i = 1;
        }



        // STEP 2: Process remaining elements in PAIRS

        while (i < n - 1) {

            // First compare elements within pair
            if (nums[i] < nums[i + 1]) {

                // Compare smaller with current min
                min = Math.min(min, nums[i]);

                // Compare larger with current max
                max = Math.max(max, nums[i + 1]);
            }

            else {

                // Compare smaller with current min
                min = Math.min(min, nums[i + 1]);

                // Compare larger with current max
                max = Math.max(max, nums[i]);
            }

            // Move to next pair
            i += 2;
        }



        // Return result as array: [min, max]
        return new int[]{min, max};
    }
}