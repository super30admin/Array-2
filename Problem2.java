/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N/2)
Take two variables which stores current max and current min and take pair of elements at each iteration.
**/


class Main {
  public static void main(String[] args) {
    int[] input = {8,6,-4,15,12,10,2,1};
    
    if(input == null || input.length < 1)
      System.out.println("Null Array");

    int max = input[0];
    int min = input[0];



    for(int i = 0; i<input.length; i= i+2){
      int currmax = max;
      int currmin = min;
      if((i+1) == input.length){
        currmax = input[i];
        currmin = input[i];
      }
      else{
        if(input[i]>input[i+1]){
          currmax = input[i];
          currmin = input[i+1];
        }else{
          currmax = input[i+1];
          currmin = input[i];
        }
      }
      if(currmax > max)
        max = currmax;
      
      if(currmin < min)
        min = currmin;
    }

    System.out.println("Max = " + max);
    System.out.println("Min = " + min);
  }
}
