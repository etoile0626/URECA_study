import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest {
    public void test(){

    }

    @DisplayName("문자열 비교")
    @Test
    public void test2(){
        String a = "hello", b ="hello";

        Assertions.assertEquals(a, b);
    }
}
