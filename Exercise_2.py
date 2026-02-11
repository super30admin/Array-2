'''
Min and Max of array using minimum number of comparisons

Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparisons?

Solution 1: Sub-optimal (1-element approach)
Compare the first two values in the array and initialize m, M as the min and max values respectively. That's 1 comparison.
For the remaining i=2,..N-1 indices (N-2 values), we make at the most 2 comparisons to figure if A[i] < m or if A[i] > M. Because if A[i] lies between m and M (m < A[i] < M), then there is nothing to be updated for m and M. Thus,
        if A[i] < m:
            m = A[i]
        elif A[i] > M:
            M = A[i]
At the end of the loop, we would have made at most 2(N-2) comparisons.
Total comparisons: 1 + 2(N-2)
Time: O(N), Space: O(1)

Solution 2: Optimal (2-element approach)
If N is odd, set m (min) and M (max) as the first element in the array. Taht's 0 comparison.
If N is even, compare the first two values in the array and initialize
    m, M as the min and max values respectively. That's 1 comparison.

For all the remaining elements (N-1 for odd N and N-2 for even N),
compare A[i] with A[i+1]. That's 1 comparison.
    If A[i] < A[i+1], we check if A[i] < m or if A[i+1] > M. Because if m and M lie between A[i] and A[i+1] (i.e., A[i] < m < M < A[i+1]), then we have nothing to update for m and M. That's 2 comparisons.

    Else (A[i] > A[i+1]), we check if A[i+1] < m or if A[i] > M. Because if m and M lie between A[i+1] and A[i] (A[i+1] < m < M < A[i]), then we have nothing to update for m and M. That's 2 comparisons.

    Hence, at the end of each iteration, we make 3 comparisons.

Total comparisons:
    3(N-1)/2 comparisons, if N odd
    1 + 3(N-2)/2 comparisons, if N even

If the target is to make fewer than 2(N-2) comparsions, it is possible to achieve this target if:
    for N = odd, 3(N-1)/2 < 2(N-2). Solving for N, we get N > 5
    for N = even, 1 + 3(N-2)/2 < 2(N-2).  Solving for N, we get N > 4
Time: O(N), Space: O(1)

'''
def find_min_max_v1(A):
    '''
    Sub-optimal
    2(N-2) + 1 comparisons
    '''
    N = len(A)
    if N == 0:
        return []

    if N == 1:
        return [A[0], A[0]]

    if A[0] < A[1]:
        m, M = A[0], A[1]
    else:
        m, M = A[1], A[0]

    for i in range(2,N): # N-2
        # at max, we make 2 comparisons below
        if A[i] < m: # A[i] < m < M
            m = A[i]
        elif A[i] > M: # m < M < A[i]
            M = A[i]
        else: # m < A[i] < M
            # nothing to be updated for m and M
            pass

    return [m, M]

def find_min_max_v2(A):
    '''
    More optimal
    if N odd: 0 + 3(N-1)/2 comparisons
    if N even: 1 + 3(N-2)/2 comparisons
    '''
    N = len(A)
    if N == 0:
        return []

    if N % 2 == 1: # odd
        # 0 comparison
        m, M = A[0], A[0]
        j = 1
    else: # even
        # 1 comparison
        if A[0] < A[1]:
            m, M = A[0], A[1]
        else:
            m, M = A[1], A[0]
        j = 2

    # Loop (N-1)/2 times for odd N, or
    # Loop (N-2)/2 times for even N
    for i in range(j,N,2):
        if A[i] <= A[i+1]: # 1 comparison
            # we make 2 comparisons below
            if A[i] < m: # A[i] < m < M
                m = A[i]

            if A[i+1] > M: # m < M < A[i+1]
                M = A[i+1]
        else: # A[i] > A[i+1]
            # we make 2 comparisons below
            if A[i+1] < m: # A[i+1] < m < M
                m = A[i+1]

            if A[i] > M: # m < M < A[i]
                M = A[i]

    return [m, M]

def run_find_min_max():
    tests = [([3,4,5,6,3,1,2,4], [1,6]), ([3,4,5,6,3,1,-1], [-1,6])]

    for test in tests:
        A, ans = test[0], test[1]
        print(f"\nA = {A}")
        result = find_min_max_v1(A)
        print(f"v1 (sub-optimal) solution: Min = {result[0]}, Max = {result[1]}")
        print(f"Pass: {ans == result}")

    for test in tests:
        A, ans = test[0], test[1]
        print(f"\nA = {A}")
        result = find_min_max_v2(A)
        print(f"v2 (optimal) solution: Min = {result[0]}, Max = {result[1]}")
        print(f"Pass: {ans == result}")

run_find_min_max()
