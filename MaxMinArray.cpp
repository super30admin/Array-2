// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// Note - This approach has 3n/2 comparisions in total since we are comparing in pairs inside our input vector.

int findMin(vector<int>& arr){
    int minimum = arr[0];
    for(int i = 0; i < arr.size()-1; i += 2){
        if(arr[i] < arr[i+1])
            minimum = min(minimum, arr[i]);
        else
            minimum = min(minimum, arr[i+1]);
    }
    return minimum;
}

int findMax(vector<int>& arr){
    int maximum = arr[0];
    for(int i = 0; i < arr.size()-1; i += 2){
        if(arr[i] > arr[i+1])
            maximum = max(maximum, arr[i]);
        else
            maximum = max(maximum, arr[i+1]);
    }
    return maximum;
}

vector<int> findMinMax(vector<int>& arr){
    vector<int> answer(2);
    int maxi = arr[0];
    int mini = arr[0];
    for(int i = 0; i < arr.size()-1; i += 2){
        if(arr[i] < arr[i+1]){
            maxi = max(maxi, arr[i+1]);
            mini = min(mini, arr[i]);
        }
        else{
            maxi = max(maxi, arr[i]);
            mini = min(mini, arr[i+1]);
        }
    }
    answer[0] = maxi;
    answer[1] = mini;
    return answer;
}

int main(){
    vector<int> arr;
    arr = {-2, 3, 5, 1, 6, 3, 8, 4, 8, 6, 9, -3, -5, 83};
    if(arr.size() == 0){
        cout << "Invalid Testcase";
        return 0;
    }
    vector<int> maxMin = findMinMax(arr);
    int max = findMax(arr);
    int min = findMin(arr);
    cout << "Max: " << max << endl;
    cout << "Min: " << min << endl << endl;
    cout << "Via a single function:" << endl;
    cout << "Max: " << maxMin[0] << endl;
    cout << "Min: " << maxMin[1] << endl;
    return 0;
}