// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach - looped over the arr, and compared the element with
//the min and max during the for loop.

/**
 * MinAndMax : MinAndMax
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 07, 2024)
 * @since : 1.0 (Nov 07, 2024)
 */
public class MinAndMax {
    public static void minAndMax(int arr[]){
        int min = arr[0], max = arr[0];
        for(int i : arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println("Min - " + min);
        System.out.println("Max - " + max);

    }

    public static void main(String args[]){
        int arr[] = new int[]{4,2,1,5,6,-1};
        minAndMax(arr);
    }
}
