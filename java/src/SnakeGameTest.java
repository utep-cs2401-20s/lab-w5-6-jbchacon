import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {
boolean[][] b1=  {{true,true,true,false,false},
                 {false, false, true, true,false},
                 {false,false,false,true,false}};

boolean[][] b2= {{false,true,true,true},
                {false,false,false,true},
                {false,false,false,true},
                {false,false,false,true}};

boolean[][] b3={{true,false,false},
                {true,true,false},
                {false,true,false},
                {true,true,true},
                {false,false,true}};
    boolean[][] b4=   {{true, true, true, true},
                        {true, true, true, true},
                        {true, true, true, true}};
    boolean[][] b5 = {{true, true},
                      {false, false}};

    @Test
    //Testing the board and if its compatible with the exhaustive method
    public void findTailExhaustive(){
        int [] result = {2, 3, 6};
        SnakeGame board = new SnakeGame(b1, 0, 0);
        assertArrayEquals(result, board.findTailExhaustive());

    }

@Test
    public void findTailExhaustive1(){//tests a board with 4x4 array
    int[] result = {3,3,6};
    SnakeGame sol = new SnakeGame(b2, 1,1);
    assertArrayEquals(result,sol.findTailExhaustive());
}
@Test
    public void findTailExhaustive3(){//tests a longer snake and a 5x3 array
        int[] result = {4,2,8};
        SnakeGame board = new SnakeGame(b3, 6,1);
        assertArrayEquals(result,board.findTailExhaustive());
    }
@Test
    public void findTailExhaustive4(){//tests board with no falses
        int [] result = {0, 0, 12};
        SnakeGame board = new SnakeGame(b4, 1, 1);
        assertArrayEquals(result, board.findTailExhaustive());

    }
    @Test
    public void findTailExhaustive5(){//tests a 2x2 array
        int [] result = {0, 0, 2};
        SnakeGame board = new SnakeGame(b5, 0, 1);
        assertArrayEquals(result, board.findTailExhaustive());

    }
    @Test
    //Testing the board and if its compatible with the recursive method
    public void Recursion(){
        int [] result = {0, 0, 6};
        SnakeGame board = new SnakeGame(b1, 0, 0);
        assertArrayEquals(result, board.findTailRecursive());
    }
    @Test
    //tests a board with 4x4 array
    public void Recursion1(){
        int [] result = {0, 0, 6};
        SnakeGame board = new SnakeGame(b2, 0, 0);
        assertArrayEquals(result, board.findTailRecursive());

    }
    @Test
    //tests a longer snake and a 5x3 array
    public void Recursion2(){
        int [] result = {2, 1, 8};
        SnakeGame board = new SnakeGame(b3, 1, 0);
        assertArrayEquals(result, board.findTailRecursive());

    }
    @Test
    //tests board with no falses
    public void Recursion3(){
        int [] result = {0, 1, 8};
        SnakeGame board = new SnakeGame(b4, 0, 0);
        assertArrayEquals(result, board.findTailRecursive());

    }
    @Test
    //tests a 2x2 array
    public void Recursion4(){
        int [] result = {0, 0, 2};
        SnakeGame board = new SnakeGame(b5, 0, 0);
        assertArrayEquals(result, board.findTailRecursive());

    }
}