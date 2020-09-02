//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
//  getMinAndMax


#include <iostream>
#include <vector>

using namespace std;


class Solution{
public:
    
    //[2,93,4,70,65,12,78] - odd number of elements
    //[2,93,4,70,65,12] - even number of elements
    //compare in pairs, 3 comparision per pair + 2 comparisions if array size is odd. TC:3*(N/2)+2
    vector<int> getMinAndMax1(vector<int> nums){
        vector<int> minmax(2);
        if(nums.size()==0)
            return minmax;
        int minele=INT_MAX, maxele=INT_MIN;
        for(int i=0;i<nums.size()-1;i+=2){
            if(nums[i]<=nums[i+1])
            {
                if(nums[i]<minele) minele=nums[i];
                if(nums[i+1]>maxele) maxele=nums[i+1];
            }
            else{
                if(nums[i+1]<minele) minele=nums[i+1];
                if(nums[i]>maxele) maxele=nums[i];
            }
        }
        if(nums.size()%2==1){
            if(nums.back()>maxele) maxele=nums.back();
            if(nums.back()<minele) minele=nums.back();
        }
        minmax[0]=minele;
        minmax[1]=maxele;
        return minmax;
    }
    
    
    //Number of comparisions 2N
    vector<int> getMinAndMax(vector<int> nums){
        vector<int> minmax(2);
        int minele=INT_MAX, maxele=INT_MIN;
        
        for(int i=0;i<nums.size();i++){
            minele=min(nums[i],minele);
            maxele=max(nums[i],maxele);
        }
        minmax[0]=minele;
        minmax[1]=maxele;
        return minmax;
    }
};

int main() {
  vector<int> nums= {1000, 11, 445, 1, 330, 000};
  vector<int> minmax;
  Solution s;
  minmax=s.getMinAndMax1 (nums);
  cout<< minmax[0]<<"\t"<<minmax[1]<<endl;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
