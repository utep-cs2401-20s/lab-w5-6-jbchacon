public class SnakeGame {
    private boolean[][] game;
    private int[] headposition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        int [][] board = new int [1][1];

    }
    public SnakeGame(boolean [][]game,int x, int y) {
        headposition[0] = x;
        headposition[1] = y;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; i < game[i].length; j++) {
               this.game[i][j] = game[i][j];
            }
        }
    }
    public int[] findTailExhaustive() {
        resetCounters();
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; i < game[i].length; j++) {
                if (game[i][j] == true) {
                    if ([i]<0||i>game.length) {
                    }
                }
                el
            }
        }
    }
    public int[] findTailRecursive(){

    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }
    private void resetCounters(){
        exhaustiveChecks=0;
        recursiveChecks=0;

    }
    private static int getRecursiveChecks(){

    }
    private static int getExhaustiveChecks(){

    }
}
