//space - constant
//time - 3(n - 1) / 2 comparisons - O(n)
class Main {
  public static void main(String[] args) {
    int[] result = minMax(new int[] {1, 2, 3, 4, 5});
    System.out.println(result[0]);
    System.out.println(result[1]);
  }

  public static int[] minMax(int[] nums) {
    int[] result = new int[2];
    //result[0] = min and result[1] = max
    int index = 0;
    //if nums length is even then initialize result with min and max among 1st 2 elements and start from index 2
    //else initialize both min and max to 1st element and start from index 1
    if(nums.length % 2 == 0)
    {
      result[0] = Math.min(nums[0], nums[1]);
      result[1] = Math.max(nums[0], nums[1]);
      index = 2;
    }
    else
    {
      result[0] = nums[0];
      result[1] = nums[1];
      index = 1;
    }
    //jump by 2 elements till 2nd last element
    for(int i = index; i < nums.length - 1; i += 2)
    {
      //update min and max accordingly
      if(nums[i] > nums[i + 1])
      {
        if(nums[i] > result[1]) result[1] = nums[i];
        if(nums[i + 1] < result[0]) result[0] = nums[i + 1];
      }
      else
      {
        if(nums[i] < result[0]) result[0] = nums[i];
        if(nums[i + 1] > result[1]) result[1] = nums[i + 1];
      }
    }
    return result;
  } 
}
