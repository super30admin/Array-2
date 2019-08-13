class Problem3:
	def LifeGame(self, matrix):
		rows = len(matrix)
		columns = len(matrix[0])
		result = [x[:] for x in matrix]
		for i in range(rows):
			for j in range(columns):
				one_count = 0
				# check for top element
				if i > 0 and matrix[i - 1][j] == 1:
					one_count += 1
				
				# check for bottom element
				if i < rows - 2 and matrix[i + 1][j] == 1:
					one_count += 1

				# check for right element
				if j < columns - 2 and matrix[i][j + 1] == 1:
					one_count += 1

				# check for left element
				if j > 0 and matrix[i][j - 1] == 1:
					one_count += 1

				# check for right bottom diagonal element
				if i < rows - 1 and j < columns - 1 and matrix[i + 1][j + 1] == 1:
					one_count += 1

				# check for top left diagonal element
				if i > 0 and j > 0 and matrix[i - 1][j - 1] == 1:
					one_count += 1

				# check for top right diagonal element
				if i > 0 and j < columns - 1 and matrix[i - 1][j + 1] == 1:
					one_count += 1

				# check for bottom left diagonal element
				if i < rows - 1 and j > 0 and matrix[i + 1][j - 1] == 1:
					one_count += 1

				if matrix[i][j] == 1:
					if one_count < 2:
						result[i][j] = 0
					elif one_count > 3:
						result[i][j] = 0
				else:
					if one_count == 3:
						result[i][j] = 1
		return result

if __name__ == '__main__':
	lg = Problem3()
	print(lg.LifeGame([[0,1,0], [0,0,1], [1,1,1], [0,0,0]]))