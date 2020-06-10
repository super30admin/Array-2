/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class MinMaxComparision {
        int min,max;
    
        public int[] getMinMax(int arr[], int n) { 
            int i; 
    
            /*If there is only one element then return it as min and max both*/
            if (n == 1) { 
                max = arr[0]; 
                min = arr[0]; 
                return new int[]{min,max};
            } 
    
            /* If there are more than one elements, then initialize min 
        and max*/
            if (arr[0] > arr[1]) { 
                max = arr[0]; 
                min = arr[1]; 
            } else { 
                max = arr[1]; 
                min = arr[0]; 
            } 
    
            for (i = 2; i < n; i++) { 
                if (arr[i] > max) { 
                    max = arr[i]; 
                } else if (arr[i] < min) { 
                    min = arr[i]; 
                } 
            } 
    
            return new int[]{min,max}; 
        } 
    
        public static void main(String args[]) { 
            MinMaxComparision obj = new MinMaxComparision();
            int myArr[] = {1000, 11, 445, 1, 330, 3000}; 
            int size = 6; 
            int[] result = obj.getMinMax(myArr, size); 
            System.out.println("Min : "+ result[0]); 
            System.out.println("Max : "+ result[1]);
    
        } 
    
}