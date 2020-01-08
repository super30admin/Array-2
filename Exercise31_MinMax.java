/********* Time Complexity (Comparisons): 3*(N-1)/2 **********/

class Solution{
	
	public static void min&max(int[] array){
		int n=7;
		int[] array = new int[]{3,6,1,8,9,4};

        //let first element be equal to min and max both
		min = array[0];
		max = array[0];
		
		//i=i+2 -> cz we are taking pair and comparing them with min and max
		for(int i =1; i<array.length-1;i=i+2){
			
			// if left with single element at the end
			// compare it with both max and min		
			if(i== n-1){
				min = Math.min(min, array[i+1]);
				max = Math.max(max, array[i]);
			}
			// i > i+1
			if(array[i] > array[i+1]){
				min = Math.min(min, array[i+1]);
				max = Math.max(max, array[i]);
			}
			else{
                //i < i+1
				min = Math.min(min, array[i]);
				max = Math.max(max, array[i+1]);
			}
		}
		
		
		System.out.println(max);
		System.out.println(min);
					
	}

}