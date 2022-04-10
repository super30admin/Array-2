// Time Complexity : O(n) - Iterating all numbers
// Space Complexity :  1. Iterative : O(1); 2. Recursive - O(Log(n))
// Comparisions : Totat comparision = 3n/2 -2
// Did this code successfully run on Leetcode : Not present on leetcode.
// Any problem you faced while coding this : No
// My Notes : 1. Recursive approach - partiion till the size of the arr is either 1 or 2; then check the min and max in pairs.
// 2, Iterative approach - store the first 2 or 1 element based on the EVEN | ODD condition and then keep comparing till the end in pairs (i+=2);

/**
 * Recursive Way
 *
 * */
public class Main {
    int[] pair = null;
    public void compute(int arr[]){
        pair = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        partition(arr, 0, arr.length-1);
        System.out.println(" Pair Min, Max : "+pair[0]+","+pair[1]);
    }
    
    public int[] partition(int[] arr,int l, int r){
        //System.out.println("Before l,r : "+l+","+r +" Pair : "+pair[0]+","+pair[1]);
        // Check if size is 1 or 0
        if(l == r || (r-l)==1){
            // 1 elem present || 2 elems present
            if(arr[l] > arr[r]){
                return new int[]{arr[r],arr[l]};
            }else{
                return new int[]{arr[l],arr[r]};
            }
        } else{
            // send for partition again.
            if(l<r){
                int mid = l + (r-l)/2;
                // partition left and right
                int[] pairTempL = partition(arr, l, mid);
                int[] pairTempR = partition(arr, mid+1, r);
                // Compare Min
                pair[0] = (pairTempL[0] < pairTempR[0]) ? pairTempL[0] : pairTempR[0];
                // Compare Max
                pair[1] = (pairTempL[1] > pairTempR[1]) ? pairTempL[1] : pairTempR[1];
            }
            //System.out.println("After l,r : "+l+","+r +" Pair : "+pair[0]+","+pair[1]);
        }
        return new int[]{pair[0],pair[1]};
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,5,6,7,8,-1,10};
        System.out.println("Checking Min Max in an array!");
        Main obj = new Main();
        obj.compute(arr);
    }
}

/**
 *  Iterative way 
 * */
public class Main {
    int[] pair = null;
    public void compute(int arr[]){
        pair = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        // Based on odd or even condition; check the first two node;
        // Currently just written for even case
        pair[0] = arr[0];
        if(arr[0]>arr[1]){
            pair[0] = arr[1];
        }else{
            pair[1] = arr[0];
        }
        
        // Compare from the remaining elems; which is 2.
        for(int i = 2;i<arr.length;i+=2){
            if(arr[i] > arr[i+1]){
                //Max compare
                if(arr[i]>pair[1]){
                    pair[1] = arr[i];
                }
                // Min compare
                if(arr[i+1]<pair[0]){
                    pair[0] = arr[i+1];
                }
            }else{
                //Min compare
                if(arr[i]<pair[0]){
                    pair[0] = arr[i];
                }
                //Max compare
                if(arr[i+1]>pair[1]){
                    pair[1] = arr[i+1];
                }
            }
            //System.out.println(" i "+i);
        }
       // System.out.println(" Pair Min, Max : "+pair[0]+","+pair[1]);
    }

    
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,5,6,7,8,-1,10,11};
        System.out.println("Hello World!");
        Main obj = new Main();
        obj.compute(arr);
    }
}