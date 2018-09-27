import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    static CharacterComparator byN = new OffByN(5);

    // Your tests go here.
    @Test
    public void charTest(){

        assertEquals(offByOne.equalChars('x', 'y'), true);
        assertEquals(offByOne.equalChars('v', 'v'), false);
    }

    //Off by N equal chars test

    @Test
    public void offByNTest(){

        assertEquals(byN.equalChars('f', 'a'), true);
        assertEquals(byN.equalChars('f', 'b'), false);


    }
}


