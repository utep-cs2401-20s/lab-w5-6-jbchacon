public class SnakeGame {
    private boolean[][] game;
    private int[] headposition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        int[][] board = new int[1][1];

    }

    public SnakeGame(boolean[][] game, int x, int y) {
        headposition = new int[]{x, y};
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {

                this.game[i][j] = game[i][j];
            }
        }
    }

    public int[] findTailExhaustive() {//tail is true element with exactly one neighbor
       int length=0;
        resetCounters();
        int[] result = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; i < game[i].length; j++) {

                if (game[i][j]==true) {
                    length++;
                    if (i == headposition[0] && j == headposition[1]) {
                        length++;
                        exhaustiveChecks++;
                        continue;

                    }
                    else if (neighbors(i, j) == 1) {//i and k are telling current spot so wheres the top so you have to subtact the i and k is to the sides ifyou uses a helper method itll help you in the long run you need to finish the helper method essentially you could get it from the other one
                        result[0] = i;// even tho you shouldnt just change the variables but yea its almost the same my only q is the length for the length you need to make another method to return it so it wont be red
                        result[1] =  j;
                        length++;
                    }
                }
            }
        }
        result[2] = length;
        return result;
    }
    public int neighbors(int i, int j) {
        int counter = 0;
        counter += result(i - 1,j - 1) ;
        counter += result( i,j - 1);
        counter +=result(i + 1,j - 1) ;
        counter +=result(i - 1,j) ;
        counter +=result(i + 1,j) ;
        counter +=result(i - 1,j + 1) ;
        counter +=result(i,j + 1) ;
        counter +=result(i + 1,j + 1) ;
        return counter;
    }
    public int result(int i,int j){
        if (i < 0 || i >= game.length) {
            return 0;
        }
        else if(j<0|| j<game.length){
            return 0;
        }else {
            return 1;
        }
    }
    public int[] findTailRecursive(){
     int currentPosition[]=new int []{headposition[0]};
        if (==neighbors()){

        }
    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
    int a[]= new int[]{headposition[0] + 1, headposition[1]};
        return a;
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
