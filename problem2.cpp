#include<iostream>
#include<vector>

using namespace std;

struct Pair{

    int min_val = INT_MAX;
    int max_val = INT_MIN;

};

void helper(vector<int> &ip,struct Pair& min_max){
    int n = ip.size();
    
    if(n == 1){
        min_max.min_val = ip.at(0);
        min_max.max_val = ip.at(0);
        return;
    }
    int i{};

    if(n%2 == 0){
        if(ip.at(0)<ip.at(1)){
            min_max.min_val = ip.at(0);
            min_max.max_val = ip.at(1);
        }
        else{
            min_max.min_val = ip.at(1);
            min_max.max_val = ip.at(0);
        }
        i=2;
    }
    else{
        min_max.min_val = ip.at(0);
        min_max.max_val = ip.at(0);
        i = 1;
    }
    while(i<n-1){
        if(ip[i]>ip[i+1]){
            min_max.min_val = min(ip[i+1],min_max.min_val);
            min_max.max_val = max(ip[i],min_max.max_val);
        }
        else{
            min_max.min_val = min(ip[i],min_max.min_val);
            min_max.max_val = max(ip[i+1],min_max.max_val);
        }
    }


}

int main(int argc, char const *argv[])
{
    
    vector<int> ip {12,31,41,34,12,3,12,34,4,35,6,43,15,134};

    struct Pair min_max;

    helper(ip,min_max);

    return 0;
}
