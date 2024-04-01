import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String equation = "x+5-3+x=6+x-2";
        String expected = "x=2";
        String actual = new Solution().solveEquation(equation);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        String equation = "0x=0";
        String expected = "Infinite solutions";
        String actual = new Solution().solveEquation(equation);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3(){
        String equation = "-x=1";
        String expected = "x=-1";
        String actual = new Solution().solveEquation(equation);

        Assert.assertEquals(expected, actual);
    }
}
