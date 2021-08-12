class Problem3:



	def LifeGame1(self, matrix):



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







	def LifeGame2(self, matrix):



		rows = len(matrix)



		columns = len(matrix[0])



		for i in range(rows):



			for j in range(columns):



				one_count = 0



				# living to dead transformation - 2



				# dead to living transformation - 3







				# check for top element



				if i > 0 and (matrix[i - 1][j] == 1 or matrix[i - 1][j] == 2):



					one_count += 1



				



				# check for bottom element



				if i < rows - 2 and (matrix[i + 1][j] == 1 or matrix[i + 1][j] == 2):



					one_count += 1







				# check for right element



				if j < columns - 2 and (matrix[i][j + 1] == 1 or matrix[i][j + 1] == 2):



					one_count += 1







				# check for left element



				if j > 0 and (matrix[i][j - 1] == 1 or matrix[i][j - 1] == 2):



					one_count += 1







				# check for right bottom diagonal element



				if i < rows - 1 and j < columns - 1 and (matrix[i + 1][j + 1] == 1 or matrix[i + 1][j + 1] == 2):



					one_count += 1







				# check for top left diagonal element



				if i > 0 and j > 0 and (matrix[i - 1][j - 1] == 1 or matrix[i - 1][j - 1] == 2):



					one_count += 1







				# check for top right diagonal element



				if i > 0 and j < columns - 1 and (matrix[i - 1][j + 1] == 1 or matrix[i - 1][j + 1] == 2):



					one_count += 1







				# check for bottom left diagonal element



				if i < rows - 1 and j > 0 and (matrix[i + 1][j - 1] == 1 or matrix[i + 1][j - 1] == 2):



					one_count += 1







				if matrix[i][j] == 1:



					if one_count < 2:



						matrix[i][j] = 2



					elif one_count > 3:



						matrix[i][j] = 2



				else:



					if one_count == 3:



						matrix[i][j] = 3



		for i in range(rows):



			for j in range(columns):



				if matrix[i][j] == 2:



					matrix[i][j] = 0



				elif matrix[i][j] == 3:



					matrix[i][j] = 1



		return matrix







if __name__ == '__main__':



	lg = Problem3()



	print(lg.LifeGame1([[0,1,0], [0,0,1], [1,1,1], [0,0,0]]))



	print(lg.LifeGame2([[0,1,0], [0,0,1], [1,1,1], [0,0,0]]))