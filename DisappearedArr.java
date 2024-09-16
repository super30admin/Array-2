package Day12;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DisappearedArr {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     /*
        //Approach 1: TC-> O(n) SC-> O(n) of the hashmap
        //Approach 2: consider hasset instead of hashmap, boolean value is nowhere used

        //Keeps the numbers in the array
        HashMap<Integer, Boolean> hm = new HashMap<>();

        //add each of the umbers to the hash map
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], true);
        }

        //Resultant list
        List<Integer> res = new LinkedList<Integer>();
        //iterate over 0 - n-1 and if it doesn't exist in hashmap, add that to list
        //As list now contains the missing elements in the array
        for(int i=1; i<= nums.length; i++){
            if(!hm.containsKey(i)){
                res.add(i);
            }
        }

        return res;I
        */

    //Optimal Approach
    //TC-> O(n) SC-> O(1)

    //iterating the array
        for(int i=0; i< nums.length; i++){
        //treating value as new index
        int newIndex = Math.abs(nums[i]) - 1;

        //if there exists a value at the index position given by the element traversed make it negative

        if(nums[newIndex] > 0){
            nums[newIndex] *= -1;
        }
    }

    List<Integer> res = new LinkedList<Integer>();

    //Now traversing through 1 to length of the array
    //and for each of the corresponding index checking if the number is positive, if so, that position is not visited
    // and that's the missing number
        for(int i=1; i<= nums.length; i++){
        if(nums[i-1] > 0){
            res.add(i);
        }
    }
        return res;

    }

    public static void main(String args[]){
        DisappearedArr obj = new DisappearedArr();

        int[] nums = new int[]{4,3,2,7,8,2,3,1};

        List<Integer> res = new LinkedList<Integer>();

        res = obj.findDisappearedNumbers(nums);

        ListIterator iter = res.listIterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }


    }
}
