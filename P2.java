// Time Complexity :o(n)
// Space Complexity :o(1)
//passed in leetcode playground
// Any problem you faced while coding this : no

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr =new int[]{1,2,7,4,6,-1};
        int[] res = getMinMax(arr, 6);
        for(int i =0;i<res.length;i++)
        {
        System.out.println(res[i]);   
        }
    }
    
public static int[] getMinMax(int arr[], int n) {
    int[] minmax = new  int[2];
    //0-min
    //1-max
    int i;

    //If there is only one element then return it as min and max both*/
    if (n == 1) {
        minmax[1] = arr[0];
        minmax[0] = arr[0];
        return minmax;
    }

    // If there are more than one elements, then initialize min and max
    if (arr[0] > arr[1]) {
        minmax[1] = arr[0];
        minmax[0] = arr[1];
    } else {
        minmax[1] = arr[1];
        minmax[0] = arr[0];
    }

    for (i = 2; i < n; i++) {
        if (arr[i] > minmax[1]) {
            minmax[1] = arr[i];
        } else if (arr[i] < minmax[0]) {
            minmax[0] = arr[i];
        }
    }

    return minmax;
}
}