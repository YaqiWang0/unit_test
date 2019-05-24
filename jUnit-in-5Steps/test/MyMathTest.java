import Junit.junit.MyMath;
import org.junit.*;

import static org.junit.Assert.*;

public class MyMathTest {

    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public  void  after(){
        System.out.println("after");
    }
    @BeforeClass
    public static void beforeclass(){
        System.out.println("before class");
    }
    @AfterClass
    public  static void afterclass(){
        System.out.println("after class");
    }
    @Test
    public void sum() {
        MyMath myMath=new MyMath();
        int result=myMath.sum(new int[]{1,2,3});
        assertEquals(6,result);
    }
    @Test
    public void sum1() {
        MyMath myMath=new MyMath();
        int result=myMath.sum(new int[]{1,2,3});
        assertEquals(6,result);
    }
}