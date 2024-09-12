
class FindMinMax {
    public static void findMinMax(int[]arr){
      int n = arr.length;
      int min,max;
      if(n==1){
          min=arr[0];
          max=arr[0];
      }else{
          max = arr[0];
          min = arr[1];
      for(int i=0;i<n;i=i+2){
          if(i==n-1){
             if(max<arr[i]) max = arr[i];
             if(min>arr[i]) min = arr[i];
          }
          else if(arr[i]>arr[i+1]){
              if(max<arr[i]) max = arr[i];
              if(min>arr[i+1]) min = arr[i+1];
          }else{
               if(max<arr[i+1]) max = arr[i+1];
              if(min>arr[i]) min = arr[i];
              
          }
      }
      }
        
        System.out.println(min);
        System.out.println(max);
    }
          
    
  
	public static void main (String[] args) {
	  int arr[] = {4,1,5,6,7,8,2,3,12};
	  
		findMinMax(arr);
		
	}
}