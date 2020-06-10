class Solution:
	def gameOfLife(self, board: List[List[int]]) -> None:
		"""
		Do not return anything, modify board in-place instead.
		"""
		if not board:
			return
		row = len(board)
		col = len(board[0])
		for i in range(row):
			for j in range(col):
				lives = self.countlives(board, i, j, row, col)
				if board[i][j] == 1:
					if lives>3 or lives<2:
						board[i][j] = 3
				else:
					if lives == 3:
						board[i][j] = 2
		for i in range(row):
			for j in range(col):
				if board[i][j] == 3:
					board[i][j] = 0
				elif board[i][j] == 2:
					board[i][j] = 1
		
	def countlives(self, board, i, j, row, col):
		count = 0
		dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1,1]]
		for x in dirs:
			r = i + x[0]
			c = j + x[1]
			if (r>=0 and c>=0 and r<row and c<col and (board[r][c] == 1 or board[r][c] == 3)):
				count+=1
		return count

#Time complexity - O(m*n) m = rows, n = columns of the 2d array
#Space complexity - O(1) inplace

#all testcases passed