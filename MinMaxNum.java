//Problem 32: Min Max in array in less than 2*(N-2) comparisons  
//--Comparison in pairs
// Time Complexity : O(n), n stands for number of elements
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Here I have used the technique of grouping(Comparison in pairs). For comparision, groups of two elements are made. For each group 3 comparison takes place.
  So, if the list is even , then n/2 iteration will take place and for each iteration there will be 3 comparisons which is O(3*n/2)=>O(1.5n)
  If odd list is there then make first element as min and max and then start iteration from the second element.TC=> O(3*(n-1)/2) 
*/ 

class Solution32
{
	public static void main(String[] args) {
		
		int arr[] = new int[]{7,6,10,8,4,12};
        
        int min,max,i;
        
        if(arr.length%2!=0){//array is of odd length
            min = arr[0];
            max = arr[1];
            i=1;
        }else{//array is of even length
           if(arr[0]<arr[1]){
               min = arr[0];
               max = arr[1];
           }else{
               min = arr[1];
               max = arr[0];
           }
           
           i=2;
        }
        
        
        while(i<arr.length){
            if(arr[i]<arr[i+1]){
                
                   if(arr[i]<min){
                       min = arr[i];
                   }
                   
                   if(arr[i+1]>max){
                       max = arr[i+1];
                   }
            }else{
                
                if(arr[i+1]<min){
                    min = arr[i+1];
                }
                
                if(arr[i]>max){
                    max = arr[i];
                }
                
            }
            i= i+2;
        }
        
        System.out.println("Min num is "+min);
        System.out.println("Max num is "+max);
	}
}
