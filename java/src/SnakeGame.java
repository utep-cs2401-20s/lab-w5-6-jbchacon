public class SnakeGame {
    private boolean[][] game;
    private int[] headposition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {

        int[][] board = new int[1][1];

    }
//making the board
    public SnakeGame(boolean[][] game, int x, int y) {
        this.game = new boolean[game.length][game[0].length];
        headposition = new int[]{x, y};//setting the head position
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {

                this.game[i][j] = game[i][j];
            }
        }
    }

    public int[] findTailExhaustive() {//tail is true element with exactly one neighbor
        resetCounters();
        int[] result = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (foundtail(result) == false) {//helper method to increase exhaustive checks
                    exhaustiveChecks++;
                }

                if (game[i][j]) {//if i and j are apart of the game
                    length();
                    if ((neighbors(i, j) == 1)) {//checks neighbors
                        if (i == headposition[0] && j == headposition[1]) {//finds the head
                        } else {
                            result[0] = i;
                            result[1] = j;
                        }
                    }
                    if (neighbors(i, j) >= 2) {

                        continue;
                    }

                }
            }
        }
        //System.out.println("Exhaustive checks : " + exhaustiveChecks);
        //System.out.println(" Length of snake is: "+ length());
        result[2] = length();
        return result;
    }

    public boolean foundtail(int[] result) {//helper method for exhaustive checks
        if ((result[0] == -1) && (result[1] == -1)) {

        }
        return false;
    }

    public int neighbors(int i, int j) {// checks for neighbors
        int counter = 0;// is checking up
        if (i - 1 >= 0) {
            if (game[i - 1][j]) {
                counter++;
            }
        }
        if (i + 1 < game.length) {//checking down
            if (game[i + 1][j]) {
                counter++;
            }
        }
        if (j - 1 >= 0) {//checking the the left
            if (game[i][j - 1]) {
                counter++;
            }
        }
        if (j + 1 < game[i].length) {//checking to the right
            if (game[i][j + 1]) {
                counter++;
            }
        }

        return counter;
    }

    public int length() {// helper method to determine the length
        int slength = 0;//counter
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (this.game[i][j]) {
                    slength++;
                }
            }
        }
        return slength;
    }


    public int[] findTailRecursive() {
        resetCounters();

        return findTailRecursive(headposition, headposition);
    }


    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {//has four recursive calls to go left you subtract y -1
        recursiveChecks++;
        if (neighbors(currentPosition[0], currentPosition[1]) == 1) {
            if ((headposition[0] != currentPosition[0]) && (headposition[1] != currentPosition[1])) ;{
                return new int[]{currentPosition[0], currentPosition[1], length()};
            }
        }
                if ((currentPosition[0] - 1 < game.length) && (game[0 - 1][1] == true) && (previousPosition[0] != currentPosition[0] - 1)) {// checks if apart of board, is apart of the snake, and if current is not equal to previous
                   length();
                    int[] Position = new int[]{currentPosition[0] - 1, currentPosition[1]};//checks up
                    return findTailRecursive(Position, currentPosition);
                }
                if ((currentPosition[0] + 1 < game.length) && (game[0 + 1][1] == true) && (previousPosition[0] != currentPosition[0] + 1)) {
                   length();
                    int[] Position = new int[]{currentPosition[0] + 1, currentPosition[1]};//checks down
                    return findTailRecursive(Position, currentPosition);
                }
                if ((currentPosition[1] - 1 < game.length) && (game[0][1 - 1] == true) && (previousPosition[0] != currentPosition[1] - 1)) {
                    length();
                    int[] Position = new int[]{currentPosition[0], currentPosition[1] - 1};//checks left
                    return findTailRecursive(Position, currentPosition);
                }
                if ((currentPosition[1] + 1 < game.length) && (game[0][1 + 1] == true) && (previousPosition[0] != currentPosition[1] + 1)) {
                    length();
                    int[] Position = new int[]{currentPosition[0] - 1, currentPosition[1]};//checks right
                    return findTailRecursive(Position, currentPosition);

                }



        return currentPosition;
    }

    private void resetCounters(){
        exhaustiveChecks=0;
        recursiveChecks=0;

    }
    private static int getRecursiveChecks(){
return recursiveChecks;
    }
    private static int getExhaustiveChecks(){
return exhaustiveChecks;
    }
}
