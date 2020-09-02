#// Time Complexity : O(NxM) we go through each board position
#// Space Complexity : O(1) we are reusing the input space, no additional space
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
# none
#
#
#// Your code here along with comments explaining your approach
#
# Go through the input array twice
# One time generating alive and dead state, storing it in the same input storage
# Second time to convert the state from holding 2 states to just the current 1 state
# return the state

ALIVE = 1
DEAD = 0
ALIVE_THEN_DEAD = 2
DEAD_THEN_ALIVE = 4

countAlive = (board, n, m, i, j) ->
  count = 0
  dirs = [[1,-1],[1,0],[1,1],[0,-1],[0,1],[-1,-1],[-1,0],[-1,1]]

  for dir in dirs
    r = i + dir[0]
    c = j + dir[1]

    if n > r >= 0 and m > c >= 0 and (board[r][c] is ALIVE or board[r][c] is ALIVE_THEN_DEAD)
      count += 1

  count

gameOfLife = (board) ->
  return if board == null or board.length == 0 or board[0].length == 0

  n = board.length
  m = board[0].length

  for i in [0...n]
    for j in [0...m]
      alive = countAlive(board, n, m, i, j)

      if board[i][j] == ALIVE and (alive < 2 or alive > 3)
        board[i][j] = ALIVE_THEN_DEAD
      else if board[i][j] == DEAD and alive == 3
        board[i][j] = DEAD_THEN_ALIVE

  # change board
  for i in [0...n]
    for j in [0...m]
      if board[i][j] == ALIVE_THEN_DEAD
        board[i][j] = DEAD
      else if board[i][j] == DEAD_THEN_ALIVE
        board[i][j] = ALIVE

  board

gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]])
