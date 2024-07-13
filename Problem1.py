#I used a hash map to keep track of the numbers that appear in the input list. First, I counted how many times each number occurs in the list using the hash map. Then, I went through all the numbers from 1 to n (where n is the length of the input list). For each of these numbers, I checked if it's not in the hash map. If a number isn't in the hash map, it means it's missing from the original list, so I add it to my answer list. This approach allows me to efficiently identify all the numbers that should be in the list (based on its length) but aren't actually present. The result is a list of all the missing numbers.


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hashMap = defaultdict(int)
        n = len(nums)
        answerList = []
        # for all the values in nums, storing the number of its occurences
        for i in nums:
            hashMap[i] = hashMap[i] + 1
        
        #for each value in the range [1,n] , we check , if its not present in the hashmap
        # we append it to the answerList
        for i in range(1, n+1):
            if i not in hashMap:
                answerList.append(i)

        return answerList