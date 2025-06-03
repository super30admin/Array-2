# Time O(mxn)
# Space O(1)
class Solution:
    def getNeighbours(self, i, j, r, c):
        neighbours = [ pair for pair in
            [(i-1,j-1),(i-1,j),(i-1,j+1),
            (i,j-1),(i,j+1),
            (i+1,j-1),(i+1,j),(i+1,j+1)]
            if pair[0]>=0 and pair[0]<r and pair[1]>=0 and pair[1]<c
        ]
        return neighbours

    def getNewState(self, i,j, board):
        # original state bit - 8
        # new state bit - 7
        originalState = board[i][j] & 0b01 # consider LSB only
        r = len(board)
        c = len(board[0])
        aliveNeighbours = 0

        neighbours = self.getNeighbours(i,j,r,c)
        for n in neighbours:
            if board[n[0]][n[1]]&0b01: # consider original state i.e LSB
                aliveNeighbours += 1

        newState = 0
        # rule=5
        if originalState == 1:
            if aliveNeighbours < 2:
                newState = originalState & ~0b10  # set new state to 0
                # rule=1
            elif aliveNeighbours == 2 or aliveNeighbours == 3:
                newState = originalState | 0b10
                # rule=2
            elif aliveNeighbours > 3:
                newState = originalState & ~0b10 # set new state to 0
                # rule=3
        else:
            if aliveNeighbours==3:
                newState = originalState | 0b10
                # rule=4

        # print('(%d,%d) alive=%d of %d, %d->%d rule=%d'%(i+1,j+1, aliveNeighbours,len(neighbours), originalState, newState>>1,rule))
        return newState

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        r = len(board)
        c = len(board)-1
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = self.getNewState(i,j, board)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] >>=1
