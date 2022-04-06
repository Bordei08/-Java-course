# Laboratorul 6

  * [Compulsory](#Compulsory) :heavy_check_mark:
  * [Homework](#homework)  :heavy_check_mark:
  * [Bonus](#bonus)

## Enunt

Consider a game played on a grid-shaped board. A grid is a two-dimensional structure of intersecting lines, the lines are evenly spaced, intersecting at right angles.
At the beginning of the game, there will be randomly placed small line-shaped tokens (sticks) that connect two adjacent intersections of the grid, along a line of the grid.
An intersection that is adjacent with at least one stick, is called a node.

The first player selects any node of the grid and places a circular-shaped token (stone) on it. Next, the players must alternatively choose a new unselected node that is adjacent (is connected by a stick) to the previously selected one and place a stone on it. They use stones of different colors. The player who cannot choose another node, loses the game.
In order to create a graphical user interface for the game, you may use either Swing or JavaFX.

Example of a board with randomly placed sticks and stones.

![image](https://user-images.githubusercontent.com/79217056/161818653-29d46538-b8c2-4f6a-b655-6d41c1c5b5ce.png)

## Compulsory
Nu l am trimis la timp ...
### Enunt

Create the following components:
 * The main frame of the application. :heavy_check_mark:
 * A configuration panel for introducing parameters regarding the grid size and a button for creating a new game. The panel must be placed at the top part of the frame. The panel must contain at least one label and one input component.:heavy_check_mark:
 * A canvas (drawing panel) for drawing the board. Draw the grid lines according to the values specified in the config panel. This panel must be placed in the center part of the frame.:heavy_check_mark:
 * A control panel for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame. :heavy_check_mark:

![image](https://user-images.githubusercontent.com/79217056/161819049-b3acfd72-9f27-416c-b8f6-ac1fbc0320a6.png)

## Homework

### Enunt 

 * Create the object oriented model.  :heavy_check_mark:
 * Initialize the game by generating random sticks and place them on the board. Implement either direct or retained mode for drawing the game board.  :heavy_check_mark:
 * Implement the logic of the game. When the player execute a mouse pressed operation, a stone must be drawn at the mouse location: red or blue depending on whose turn it is. Validate the move, according to the game rules. Determine the winner of the game.  :heavy_check_mark:
 * (+0.5p) Export the current image of the game board into a PNG file.  :heavy_check_mark:
 * (+0.5p) Use object serialization in order to save and restore the current status of the game.  ❌


Tabla generata pentru dimensiunile 3 cu 5

![image](https://user-images.githubusercontent.com/79217056/162073421-81ce0bec-eef5-46b7-bac1-6b12bda4967a.png)

Logica jocului 

![image](https://user-images.githubusercontent.com/79217056/162073548-61afeaab-08a5-4fc4-b522-a7e3583b884b.png)

Printscreen la joc:

![image](https://user-images.githubusercontent.com/79217056/162073739-de0d8b28-43ec-414d-8d5e-50cec6842d77.png)


## Bonus

### Enunt

 * Prove that the player who starts the game has always a winning strategy if and only if the corresponding graph does not have a perfect matching.
 * Based on the above observation, implement an AI for the game.

