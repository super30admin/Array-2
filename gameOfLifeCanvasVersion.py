# It's still incomplete


# It's on pause because i've to complete previous S30 PRs first

# I really wanted to do this thing by myself even if i'm new to python
# reason? I mean why not? it's awesome. I'm not going to focus too much on TC and SC
# because it's for fun xD

# i don't know what exactly tkinter is but it's similar to htmlcanvas in javascript
# found it on the internet to draw canvas

# from tkinter import *
# from typing import List   
# from random import *

# resolution = 40


# class GameOfLife(object):
#     # game of life is 2D so x and y ??????????
#     def createMatrix(self, rows, cols):
#         return [[0 for _ in range(rows)] for _ in range(cols)]
    
#     def getScreenDimensions(self):
#         root = Tk()
#         return [root.winfo_width(), root.winfo_height()]

#     def main(self):
#         dimensions = self.getScreenDimensions()
#         cols = int(dimensions[0] / resolution) # can also use // instead of int() for int conversion
#         rows = int(dimensions[1] / resolution) 
#         grid = self.createMatrix(rows,cols)
#         print(grid)
#         print(rows,cols)
#         for row in range(rows):
#             for col in range(cols):
#                 grid[row][col] = int((random() * 2) / 1)
#         gameBoard = Board()
#         gameBoard.draw(grid, rows, cols)
        
# # it will just create visual canvas from the array>????
# class Board(object):
#     def draw(self, grid, rows, cols):
#         board = Tk()  
#         board.geometry(str(rows) + "x" + str(cols))  
#         canvas = Canvas(board,bg = "white",height = "200")  
#         canvas.pack()
#         for row in range(rows):
#             for col in range(cols):
#                 x = row * resolution
#                 y = col * resolution
#                 if grid[row][col] == 1:
#                     # canvas.fi
#                     rect=canvas.create_rectangle(x,y,resolution+1,resolution+1, fill="black")
#                     canvas.itemconfig(rect,fill="green")
                    
        
#         canvas.mainloop()
        


# game = GameOfLife()
# game.main()
# #creating a simple canvas  

from random import randint
from typing import List
from tkinter import Tk
import turtle

class GUICanvas(object):
        def updateCanvas(self, grid: List[List[int]], rows, cols):
        # pending - draw canvas
            self.rows = rows
            self.cols = cols
            self.grid = grid
            screen = turtle.Screen()
            turtle.setup(1000,1000)
            turtle.hideturtle()
            turtle.speed(0)
            turtle.tracer(0,0)
            
            lifeturtle = turtle.Turtle() # turtle for drawing life
            lifeturtle.up()
            lifeturtle.hideturtle()
            lifeturtle.speed(0)
            lifeturtle.color('black')
            
        def createLine(self, x1,y1,x2,y2):
            turtle.up()
            turtle.goto(x1,y1)
            turtle.down()
            turtle.goto(x2,y2)

        def createBoard(self):
            turtle.pencolor('red')
            turtle.pensize(2)
            x = -400
            for i in range(self.cols+1):
                self.createLine(x, -400, x, 400)
                x += 800/self.cols
            y = -400
            for i in range(self.rows+1):
                self.createLine(-400,y,400,y)
                y += 800/self.rows
                
        def draw_square(self,x,y,size): # draws a filled square 
            self.lifeturtle.up()
            self.lifeturtle.goto(x,y)
            self.lifeturtle.down()
            self.lifeturtle.seth(0)
            self.lifeturtle.begin_fill()
            for i in range(4):
                self.lifeturtle.fd(size)
                self.lifeturtle.left(90)
            self.lifeturtle.end_fill()
        
        def draw_life(self,x,y): # draws life in (x,y)
            lx = 800/self.cols*x - 400 # converts x,y to screen coordinate 
            ly = 800/self.rows*y - 400
            self.draw_square(lx+1,ly+1,800/self.rows-2)

        def draw_all_life(self): # draws all life
            global life
            for i in range(self.rows):
                for j in range(self.cols):
                    if self.grid[i][j] == 1: self.draw_life(i,j)
        board = Board()
        
        self.nextGen(self.grid)
        lifeturtle.clear() # clears life in previous cycle
        draw_all_life()
        screen.update()
        screen.ontimer(self.updateCanvas(),200)


class Board(object):
    def __init__(self) -> None:
        self.rows = 0
        self.cols = 0
        
    def generateGrid(self):
        # 1/6 chances of getting a live cell
        return [[1 if randint(0,6) == 0 else 0 for _ in range(self.cols)] for _ in range(self.rows)]

    def countAlive(self, grid: List[List[int]], row: int, col: int):
        # we could also see the grid as infinite grid insread for fixed length
        # for ex. -1 will be the last element, but will just ignore the positions that are
        # not present 
        aliveCellsCount = 0
        # list of all possible neighbor positions a tuple list
        positions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        # pending - calculate alive cells count
        for x,y in positions:
            r = x + row
            c = y + col
            if (r >= 0 and c >= 0 or r <= len(grid) and c <= len(grid[0]) and grid[r][c] in [1,2]):
                aliveCellsCount += 1
        return aliveCellsCount
    
    
    def nextGen(self, grid: List[List[int]]):
        # the four rules
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                aliveNum = self.countAlive(grid, row, col)
                if aliveNum ==3 and grid[row][col] == 0: grid[row][col] = 3
                elif not 1 < aliveNum < 4 and grid[row][col] == 1: grid[row][col] = 2
                
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 3: grid[row][col] = 1
                if grid[row][col] == 2: grid[row][col] = 0
        return
        
    def main(self, rows: int, cols: int):
        self.rows = rows
        self.cols = cols
        grid = self.generateGrid()
        GUIBoard = GUICanvas()
        GUIBoard.updateCanvas(grid,rows,cols)
        # self.nextGen(grid)
        
game = Board()
game.main(100,100)