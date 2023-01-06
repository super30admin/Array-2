// Time Complexity : O(1.5*n)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
// To decrease no of comparisons, we take pairs of elements instead of individual
// For each pair we do 3 comparisons, so for n elements -> 1.5*n comparisons

class FindMaxAndMin { 
    private static int[] find(int arr[]) 
    { 
	    int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i=0;
        for(i=0;i+1<arr.length;i=i+2){
            if(arr[i+1]<arr[i]){
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            }
            else{
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }
        }
        if(i<arr.length){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return new int[]{min,max};
    } 
  
    public static void main(String args[]) 
    { 
        FindMaxAndMin ob = new FindMaxAndMin(); 
        int arr[] = { 1,2 }; 
        int[] result = ob.find(arr);
        System.out.println("Min: "+result[0]);
        System.out.println("Max: "+result[1]);
    } 
} 