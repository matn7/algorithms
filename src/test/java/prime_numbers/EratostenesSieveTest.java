package prime_numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mati on 20.12.2017.
 */
public class EratostenesSieveTest {


    @Test
    public void fillArray() {
        EratostenesSieve sieve = new EratostenesSieve();
        int ile = 4;
        boolean[] result = sieve.fillArray(ile);
        boolean[] expected = {false, false, true, true, true};

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void doSieve() {
        EratostenesSieve sieve = new EratostenesSieve();
        int ile = 4;
        boolean[] result = sieve.doSieve(ile);
        boolean[] expected = {false, false, true, true, false};
    }

}
