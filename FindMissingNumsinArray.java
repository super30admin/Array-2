//Challenges:
//Following technique will work only when the array is from 1-n;
//Cannot be used when numbers given in any particular range as playing with range and nums value of the array;

//for any given number make changes in index=nums-1; and make the value of that cell=-ve at the end check the positive array values and the index+1;
// will be missing from that given array;

//TC: O(N);  even though in 2 different pass: 1 making -ve and then 2nd pass counting the postive num index+1 to get the numbers;
//SC: O(1);  Not using any extra array;

//SC: O(N) if using any hashMap, hashSet and array as using an extra nth elemnt to check;

//Most Optimized:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list= new ArrayList<>();
        
        int index=0;
        for(int i=0;i<nums.length;i++){
            index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                    nums[index]=-1*nums[index];
            }
        }
        
        
    //        index=Math.abs(nums[nums[i]-1]);
    //Cannot happen so hey take the absolute value of the nums[i] first and then only check with
        //Math.abs(nums)-1 if < 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        
        return list;
        
    }
}

//Using extra data structure:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        //brute force store in map, set or array;
        HashMap<Integer, Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int[] nums1=new int[nums.length+1];
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
            set.add(nums[i]);
            nums1[nums[i]]=1;
        }
        //first store using one loop
        //second check if map contains the key or not;
        
    //map will only store the nums which are unique in the given set of the array;
        // for(int i=1;i<=nums.length;i++){
        //     if(!map.containsKey(i)){
        //         list.add(i);
        //     }
        // }
        
      //used set and array to achieve the same;
        for(int i=1;i<nums.length+1;i++){
            // if(!set.contains(i)){
            //     list.add(i);
            // }
            if(nums1[i]==0){
                list.add(i);
            }
        }
        return list;
        
    }
}
