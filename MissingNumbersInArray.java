package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],1);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=nums.length;i++)
        {
            if(map.containsKey(i)==false)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}
