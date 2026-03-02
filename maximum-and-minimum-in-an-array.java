// Time Complexity : O(n)
// Space Complexity : O(1)
// Three line explanation of solution in plain english : Initialize min and max using the first one or two elements depending on array size. 
// Iterate through the rest of the array in pairs, updating min and max efficiently. Return a list containing the final minimum and maximum values.

class Solution {
    public static List<Integer> findMinMax(ArrayList<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int mini, maxi, i;

        if (n % 2 == 1) {
            mini = maxi = arr.get(0);
            i = 1;
        } else {
            if (arr.get(0) < arr.get(1)) {
                mini = arr.get(0);
                maxi = arr.get(1);
            } else {
                mini = arr.get(1);
                maxi = arr.get(0);
            }
            i = 2;
        }

        // Process elements in pairs
        while (i < n - 1) {
            if (arr.get(i) < arr.get(i + 1)) {
                mini = Math.min(mini, arr.get(i));
                maxi = Math.max(maxi, arr.get(i + 1));
            } else {
                mini = Math.min(mini, arr.get(i + 1));
                maxi = Math.max(maxi, arr.get(i));
            }
            i += 2;
        }

        result.add(mini);
        result.add(maxi);
        return result;
    }
}
