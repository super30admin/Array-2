// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Problem not found on Leetcode

class FindMinAndMax{
    public static void main(String[] args) {
        int[] arr = {-4,3,2,7,-8,14};

        int max = arr[0], min = arr[0];

        for (int i=1; i<arr.length;i=i+2) {
            if (i == arr.length -1) {
                min = Math.min(min,arr[i]);
                max = Math.max(min,arr[i]);
            }

            else if (arr[i] < arr[i+1]) {
                min = Math.min(min,arr[i]);
                max = Math.max(max,arr[i+1]);
            }

            else if (arr[i] > arr[i+1] ) {
                min = Math.min(min,arr[i+1]);
                max = Math.max(max,arr[i]);
            }
        }

        System.out.println("Maximum number is: "+ max + ". Minimum number is: "+ min);
    }


}