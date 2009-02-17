package org.pwsafe.android;

import edu.cornell.lassp.houle.RngPack.RandomElement;
import edu.cornell.lassp.houle.RngPack.Ranmar;
import edu.cornell.lassp.houle.RngPack.RanMT;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilFunctionalTest {
    private static RandomElement mCharacterPrng;
    private static RandomElement mLengthPrng;

    @BeforeClass
    public static void setUpTestCase() {
        mCharacterPrng = new Ranmar();
        mLengthPrng = new RanMT();
    }

    @Test
    public void testDecodeEncode() {
        String expected = createAnonymousText();

        String observed = Util.decode(Util.encode(expected));

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeDecode() {
        String expected = createAnonymousHexString();

        String observed = Util.encode(Util.decode(expected));

        Assert.assertEquals(expected, observed);
    }

    private String createAnonymousHexString() {
        int length = 2*mLengthPrng.choose(256);

        char[] result = new char[length];

        for (int i = 0; i != length; ++i) {
            int hex = mCharacterPrng.choose(16)-1;

            if (hex < 10) {
                result[i] = (char) ('0' + hex);
            } else {
                result[i] = (char) ('a' + (hex - 10));
            }
        }

        return new String(result);
    }

    private String createAnonymousText() {
        int length = mLengthPrng.choose(256);

        char[] result = new char[length];

        for (int i = 0; i != length; ++i) {
            result[i] = (char) (mCharacterPrng.choose(256)-1);
        }

        return new String(result);
    }
}
