// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea is to compare each element and its next element and store min and max.
// At the end we will have overall max/min.

#include <iostream>
#include <vector>

struct minmax
{
    int min;
    int max;
};

struct minmax getMinmax(std::vector<int>&input, size_t input_size)
{
    struct minmax elem;
    
    // Set the max to -infinity and min to +infinity
    elem.max = INT_MIN;
    elem.min = INT_MAX;

    // check each element with its neighbor and store min/max. 
    for(int i = 0; i < input_size-1; i++)
    {
        if(input[i] < input[i+1])
        {
            elem.max = std::max(input[i+1], elem.max);
            elem.min = std::min(input[i], elem.min);
        }
        else{
            elem.max = std::max(input[i], elem.max);
            elem.min = std::min(input[i+1], elem.min);
        }
    }
    return elem;
}


int main()
{
    std::vector<int> input = {1000, 11, 445, 1, 330, 3000};

    int inp_size = input.size();

    struct minmax minmaxPair = getMinmax(input, inp_size);

    std::cout << "min is " << minmaxPair.min << std::endl;
    std::cout << "max is " << minmaxPair.max << std::endl; 

    return 0; 

}