import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TelevisionTest {
    Television television;

    @Before
    public void setUp() {
        television = new Television();
    }

    @Test
    public void returnTrueWhenTvIsTurnedOn() {
        television.on();
        assertTrue(television.isOn());
    }

    @Test
    public void returnFalseWhenTvIsTurnedOff() {
        television.off();
        assertFalse(television.isOn());
    }
}
