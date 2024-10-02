/**
 * @param {number[]} arr
 * @param {number} n
 * @returns {number[]}
 */

class Solution {
    getMinMax(arr) {
        //code here
        let max = arr[0];
        let min = arr[0];

        for(let i = 0; i < arr.length; i++){
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }
        return [min, max];
    }
}