import java.util.ArrayList;
import java.util.List;
//TC O(n)

//SC O(1)
public class FindNumbersDisappeared {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    //Brute force
    //TimeComplexity - O(n^2)
    //Space Complexity - O(1)
  /*  public static List<Integer> findDisappearedNumbers(int[] nums){
        List <Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            boolean checker = false;
            for (int j = 0; j < nums.length; j++) {
                if(i == nums[j]) {
                    checker = true;
                    break;
                }
            }
            if(checker==false) result.add(i);
        }
        return result;
    }*/
//HashSet Solution
    //Time Complexity - O(n)
    //Space Complexity - O(n)

  /*  public static List<Integer> findDisappearedNumbers(int[] nums){
        if(nums==null||nums.length==0) return Collections.emptyList();
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            if(!set.contains(nums[i])) set.add(nums[i]);
        }
        System.out.println(set);

        for (int i = 1; i <=nums.length; i++) {
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }*/
//HashMap solution
//Time Complexity O(n)
    //Space Complexity O(n)
 /* public static List<Integer> findDisappearedNumbers(int[] nums){
      if(nums==null||nums.length==0) return Collections.emptyList();
      HashMap<Integer,Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      for (int i = 1; i <= nums.length; i++) {
          map.put(i,0);

      }
     // System.out.println(map);

      for (int i = 0; i < nums.length ; i++) {
          if(map.containsKey(nums[i])){
              int count = map.get(nums[i]);
              map.put(nums[i],count+1);
          }
      }

      for (int i = 1; i <= nums.length; i++) {
          if(map.get(i)==0) list.add(i);
      }
      return list;
  }*/

//Binary Search
    //Time Complexity - O(nlogn)
    //Space Complexity - O(1)
/*
    public static List<Integer> findDisappearedNumbers(int[] nums){
    if(nums==null||nums.length==0) return Collections.emptyList();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums);
    int start = 0, end = nums.length-1;
    while (start<=end){
        int mid = start+(end-start)/2;

    }

    return list;
}
*/
public static List<Integer> findDisappearedNumbers(int[] nums){
    if(nums == null || nums.length==0) return new ArrayList<>();
    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    for(int i=0 ;i<n;i++){
        int index = Math.abs(nums[i])-1;
        if(nums[index]>0) nums[index]= nums[index]*-1;
    }
    for(int i = 0 ; i<n;i++){
        if(nums[i]>0) result.add(i+1);
    }
    return result;
}

}
