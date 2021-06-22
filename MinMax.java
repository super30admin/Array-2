// The time complexity of the problem is O(n) and space complexity is O(1)
class MinMax {
  public void findMinMax(int[] arr){
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
      if(min > arr[i]){
        min = arr[i];
      }
      if(max < arr[i]){
        max = arr[i];
      }
    }
    System.out.println("This is Max Value:"+max);
    System.out.println("This is Min Value:"+min);
  }
  public static void main(String[] args) {
    MinMax mm = new MinMax();
    int[] arr = {2,6,8,1,4,5,12,11,16,4,18};
    mm.findMinMax(arr);
  }
}