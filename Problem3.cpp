//
// Created by shazm on 7/20/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<int> vec{1,1,1};
        board[0] = vec;

    }

    vector<int> helper(vector<vector<int>> nums, int i, int j){
        int onecounter = 0;
    }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//    s.gameOfLife(vec);
    for(int i = 0; i<vec.size(); i++){
        for(int j = 0; j<vec[0].size(); j++){
            cout<<vec[i][j]<<"("<<i<<","<<j<<") ";
        }
        cout<<endl;
    }
    return 0;
}