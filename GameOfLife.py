#289. Game of Life
"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

We are keeping Space Complexity = O(1) so no auxilary datatypes are used.
To change in array itself, We parse through array element by element, of element and change its value according
to rules provides in question.

we change 0 -> 2 then from 2->1
and 1 -> 3 then from 3->0
We do this because newly changed elements shoulod not affect other elements
"""


class Solution:
    def liveStatus(self, board, i, j, distance):
        result = 0

        a, b = 0, 0

        # we move in fixed 8 directions to find eight neighbours(at most eight)
        for n in distance:

            a = i + n[0]
            b = j + n[1]

            # A condition to check if indexes are not going out of bound.
            # We are also checking for element == 1 and element == 3 because at this point 3 is considered as 1 only.
            if a >= 0 and b >= 0 and a < len(board) and b < len(board[0]) and (board[a][b] == 3 or board[a][b] == 1):
                result += 1

        return result

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # There are only eight ways or direction in which we can move to get neighbours
        distance = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        # check rules and change accordingly
        # we change 0 -> 2 then from 2->1 and 1 -> 3 then from 3->0
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):

                live_status = self.liveStatus(board, i, j, distance)

                if board[i][j] == 1:
                    if live_status < 2 or live_status > 3:
                        board[i][j] = 3

                if board[i][j] == 0 and live_status == 3:
                    board[i][j] = 2

        # at this point, 3 is considered 0 and 2 is considered 1.
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1