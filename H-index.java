## Problem2 H-Index (https://leetcode.com/problems/h-index/)



//In this we are sorting the array first and then finding the H-index
Time Complexity : O(n logn)
Space Complexity : O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return 0;
    }
}

//In this we are using bucket sort first and then finding the H-index
Time Complexity : O(n)
Space Complexity : O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        int n=citations.length;
        int[] citation= new int[citations.length+1];
        for(int i=0;i<n;i++){
           if(citations[i]>citations.length){
                citation[citations.length]++;
           }
           else{
            citation[citations[i]]++;
           }
        }
        int max=0;
        for(int i=citation.length-1;i>=0;i--){
            max=max+citation[i];
            if(max>=i){
                return i;
            }
        }
        return 0;
    }
}
