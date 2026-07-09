import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAATest {
    private int value;

    @Before
    public void setUp() {
        value = 10;
    }

    @After
    public void tearDown() {
        value = 0;
    }

    @Test
    public void testAddition() {
        // Arrange
        int amount = 5;
        // Act
        value += amount;
        // Assert
        assertEquals(15, value);
    }
}
