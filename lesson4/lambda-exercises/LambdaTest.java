package exercises.lesson4;

/**
 * Tests for Lesson 4.
 *
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LambdaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public final void testExample() {
        LambdaMain.runExample();
        assertEquals("Joe Clay\nMarie Smith\nAnn Thompson\nJames Bond\nJennifer Atkins\nCristina Gibbs\nJason Clark\nKate Barrett\nPeter Garner\nBen Walsh\n",outContent.toString());
    }

    @Test
    public final void testExercise1() {
        LambdaMain.runExercise1();
        assertEquals("CLAY\nSMITH\nTHOMPSON\nBOND\nATKINS\nGIBBS\nCLARK\nBARRETT\nGARNER\nWALSH\n",outContent.toString());
    }

    @Test
    public final void testExercise2() {
        LambdaMain.runExercise2();
        assertEquals("Joe\nJames\nJason\nPeter\nBen\n",outContent.toString());
    }

    @Test
    public final void testExercise3() {
        LambdaMain.runExercise3();
        assertEquals("Joe Clay 23\nJames Bond 28\nJennifer Atkins 22\nKate Barrett 25\nBen Walsh 21\n",outContent.toString());
    }

    @Test
    public final void testExercise4() {
        LambdaMain.runExercise4();
        assertTrue(outContent.toString().contains("21.1"));
    }

    @Test
    public final void testExercise5() {
        LambdaMain.runExercise5();
        assertEquals("3\n",outContent.toString());
    }

    @Test
    public final void testExercise6() {
        LambdaMain.runExercise6();
        assertEquals("17 Ann Thompson\n18 Cristina Gibbs\n18 Peter Garner\n19 Jason Clark\n20 Marie Smith\n21 Ben Walsh\n22 Jennifer Atkins\n23 Joe Clay\n25 Kate Barrett\n28 James Bond\n",outContent.toString());
    }

    @Test
    public final void testExercise7() {
        LambdaMain.runExercise7();
        assertEquals("Atkins, Jennifer\nBarrett, Kate\nBond, James\nClay, Joe\nWalsh, Ben\n",outContent.toString());
    }

    @Test
    public final void testExercise8() {
        LambdaMain.runExercise8();
        assertEquals("[2000, 1999, 1998, 1997, 1996, 1995, 1994, 1992, 1989]\n",outContent.toString());
    }
}
