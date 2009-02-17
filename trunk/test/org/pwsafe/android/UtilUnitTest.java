package org.pwsafe.android;

import junit.framework.Assert;
import org.junit.Test;

public class UtilUnitTest {
    @Test(expected=NumberFormatException.class)
    public void testDecodeInvalidLengthText() {
        String text = "0";

        String observed = Util.decode(text);
    }

    @Test
    public void testDecodeMulticharacter() {
        String expected = new String(new char[] {(char) 0x00, (char) 0xff });

        String text = "00ff";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0000() {
        String expected = new String(new char[] { (char) 0x00 });

        String text = "00";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0001() {
        String expected = new String(new char[] { (char) 0x01 });

        String text = "01";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0002() {
        String expected = new String(new char[] { (char) 0x02 });

        String text = "02";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0003() {
        String expected = new String(new char[] { (char) 0x03 });

        String text = "03";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0004() {
        String expected = new String(new char[] { (char) 0x04 });

        String text = "04";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0005() {
        String expected = new String(new char[] { (char) 0x05 });

        String text = "05";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0006() {
        String expected = new String(new char[] { (char) 0x06 });

        String text = "06";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0007() {
        String expected = new String(new char[] { (char) 0x07 });

        String text = "07";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0008() {
        String expected = new String(new char[] { (char) 0x08 });

        String text = "08";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0009() {
        String expected = new String(new char[] { (char) 0x09 });

        String text = "09";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000a() {
        String expected = new String(new char[] { (char) 0x0a });

        String text = "0a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000b() {
        String expected = new String(new char[] { (char) 0x0b });

        String text = "0b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000c() {
        String expected = new String(new char[] { (char) 0x0c });

        String text = "0c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000d() {
        String expected = new String(new char[] { (char) 0x0d });

        String text = "0d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000e() {
        String expected = new String(new char[] { (char) 0x0e });

        String text = "0e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU000f() {
        String expected = new String(new char[] { (char) 0x0f });

        String text = "0f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0010() {
        String expected = new String(new char[] { (char) 0x10 });

        String text = "10";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0011() {
        String expected = new String(new char[] { (char) 0x11 });

        String text = "11";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0012() {
        String expected = new String(new char[] { (char) 0x12 });

        String text = "12";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0013() {
        String expected = new String(new char[] { (char) 0x13 });

        String text = "13";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0014() {
        String expected = new String(new char[] { (char) 0x14 });

        String text = "14";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0015() {
        String expected = new String(new char[] { (char) 0x15 });

        String text = "15";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0016() {
        String expected = new String(new char[] { (char) 0x16 });

        String text = "16";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0017() {
        String expected = new String(new char[] { (char) 0x17 });

        String text = "17";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0018() {
        String expected = new String(new char[] { (char) 0x18 });

        String text = "18";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0019() {
        String expected = new String(new char[] { (char) 0x19 });

        String text = "19";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001a() {
        String expected = new String(new char[] { (char) 0x1a });

        String text = "1a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001b() {
        String expected = new String(new char[] { (char) 0x1b });

        String text = "1b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001c() {
        String expected = new String(new char[] { (char) 0x1c });

        String text = "1c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001d() {
        String expected = new String(new char[] { (char) 0x1d });

        String text = "1d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001e() {
        String expected = new String(new char[] { (char) 0x1e });

        String text = "1e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU001f() {
        String expected = new String(new char[] { (char) 0x1f });

        String text = "1f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0020() {
        String expected = new String(new char[] { (char) 0x20 });

        String text = "20";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0021() {
        String expected = new String(new char[] { (char) 0x21 });

        String text = "21";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0022() {
        String expected = new String(new char[] { (char) 0x22 });

        String text = "22";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0023() {
        String expected = new String(new char[] { (char) 0x23 });

        String text = "23";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0024() {
        String expected = new String(new char[] { (char) 0x24 });

        String text = "24";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0025() {
        String expected = new String(new char[] { (char) 0x25 });

        String text = "25";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0026() {
        String expected = new String(new char[] { (char) 0x26 });

        String text = "26";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0027() {
        String expected = new String(new char[] { (char) 0x27 });

        String text = "27";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0028() {
        String expected = new String(new char[] { (char) 0x28 });

        String text = "28";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0029() {
        String expected = new String(new char[] { (char) 0x29 });

        String text = "29";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002a() {
        String expected = new String(new char[] { (char) 0x2a });

        String text = "2a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002b() {
        String expected = new String(new char[] { (char) 0x2b });

        String text = "2b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002c() {
        String expected = new String(new char[] { (char) 0x2c });

        String text = "2c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002d() {
        String expected = new String(new char[] { (char) 0x2d });

        String text = "2d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002e() {
        String expected = new String(new char[] { (char) 0x2e });

        String text = "2e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU002f() {
        String expected = new String(new char[] { (char) 0x2f });

        String text = "2f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0030() {
        String expected = new String(new char[] { (char) 0x30 });

        String text = "30";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0031() {
        String expected = new String(new char[] { (char) 0x31 });

        String text = "31";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0032() {
        String expected = new String(new char[] { (char) 0x32 });

        String text = "32";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0033() {
        String expected = new String(new char[] { (char) 0x33 });

        String text = "33";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0034() {
        String expected = new String(new char[] { (char) 0x34 });

        String text = "34";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0035() {
        String expected = new String(new char[] { (char) 0x35 });

        String text = "35";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0036() {
        String expected = new String(new char[] { (char) 0x36 });

        String text = "36";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0037() {
        String expected = new String(new char[] { (char) 0x37 });

        String text = "37";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0038() {
        String expected = new String(new char[] { (char) 0x38 });

        String text = "38";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0039() {
        String expected = new String(new char[] { (char) 0x39 });

        String text = "39";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003a() {
        String expected = new String(new char[] { (char) 0x3a });

        String text = "3a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003b() {
        String expected = new String(new char[] { (char) 0x3b });

        String text = "3b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003c() {
        String expected = new String(new char[] { (char) 0x3c });

        String text = "3c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003d() {
        String expected = new String(new char[] { (char) 0x3d });

        String text = "3d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003e() {
        String expected = new String(new char[] { (char) 0x3e });

        String text = "3e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU003f() {
        String expected = new String(new char[] { (char) 0x3f });

        String text = "3f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0040() {
        String expected = new String(new char[] { (char) 0x40 });

        String text = "40";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0041() {
        String expected = new String(new char[] { (char) 0x41 });

        String text = "41";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0042() {
        String expected = new String(new char[] { (char) 0x42 });

        String text = "42";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0043() {
        String expected = new String(new char[] { (char) 0x43 });

        String text = "43";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0044() {
        String expected = new String(new char[] { (char) 0x44 });

        String text = "44";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0045() {
        String expected = new String(new char[] { (char) 0x45 });

        String text = "45";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0046() {
        String expected = new String(new char[] { (char) 0x46 });

        String text = "46";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0047() {
        String expected = new String(new char[] { (char) 0x47 });

        String text = "47";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0048() {
        String expected = new String(new char[] { (char) 0x48 });

        String text = "48";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0049() {
        String expected = new String(new char[] { (char) 0x49 });

        String text = "49";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004a() {
        String expected = new String(new char[] { (char) 0x4a });

        String text = "4a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004b() {
        String expected = new String(new char[] { (char) 0x4b });

        String text = "4b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004c() {
        String expected = new String(new char[] { (char) 0x4c });

        String text = "4c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004d() {
        String expected = new String(new char[] { (char) 0x4d });

        String text = "4d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004e() {
        String expected = new String(new char[] { (char) 0x4e });

        String text = "4e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU004f() {
        String expected = new String(new char[] { (char) 0x4f });

        String text = "4f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0050() {
        String expected = new String(new char[] { (char) 0x50 });

        String text = "50";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0051() {
        String expected = new String(new char[] { (char) 0x51 });

        String text = "51";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0052() {
        String expected = new String(new char[] { (char) 0x52 });

        String text = "52";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0053() {
        String expected = new String(new char[] { (char) 0x53 });

        String text = "53";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0054() {
        String expected = new String(new char[] { (char) 0x54 });

        String text = "54";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0055() {
        String expected = new String(new char[] { (char) 0x55 });

        String text = "55";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0056() {
        String expected = new String(new char[] { (char) 0x56 });

        String text = "56";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0057() {
        String expected = new String(new char[] { (char) 0x57 });

        String text = "57";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0058() {
        String expected = new String(new char[] { (char) 0x58 });

        String text = "58";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0059() {
        String expected = new String(new char[] { (char) 0x59 });

        String text = "59";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005a() {
        String expected = new String(new char[] { (char) 0x5a });

        String text = "5a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005b() {
        String expected = new String(new char[] { (char) 0x5b });

        String text = "5b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005c() {
        String expected = new String(new char[] { (char) 0x5c });

        String text = "5c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005d() {
        String expected = new String(new char[] { (char) 0x5d });

        String text = "5d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005e() {
        String expected = new String(new char[] { (char) 0x5e });

        String text = "5e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU005f() {
        String expected = new String(new char[] { (char) 0x5f });

        String text = "5f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0060() {
        String expected = new String(new char[] { (char) 0x60 });

        String text = "60";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0061() {
        String expected = new String(new char[] { (char) 0x61 });

        String text = "61";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0062() {
        String expected = new String(new char[] { (char) 0x62 });

        String text = "62";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0063() {
        String expected = new String(new char[] { (char) 0x63 });

        String text = "63";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0064() {
        String expected = new String(new char[] { (char) 0x64 });

        String text = "64";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0065() {
        String expected = new String(new char[] { (char) 0x65 });

        String text = "65";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0066() {
        String expected = new String(new char[] { (char) 0x66 });

        String text = "66";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0067() {
        String expected = new String(new char[] { (char) 0x67 });

        String text = "67";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0068() {
        String expected = new String(new char[] { (char) 0x68 });

        String text = "68";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0069() {
        String expected = new String(new char[] { (char) 0x69 });

        String text = "69";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006a() {
        String expected = new String(new char[] { (char) 0x6a });

        String text = "6a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006b() {
        String expected = new String(new char[] { (char) 0x6b });

        String text = "6b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006c() {
        String expected = new String(new char[] { (char) 0x6c });

        String text = "6c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006d() {
        String expected = new String(new char[] { (char) 0x6d });

        String text = "6d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006e() {
        String expected = new String(new char[] { (char) 0x6e });

        String text = "6e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU006f() {
        String expected = new String(new char[] { (char) 0x6f });

        String text = "6f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0070() {
        String expected = new String(new char[] { (char) 0x70 });

        String text = "70";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0071() {
        String expected = new String(new char[] { (char) 0x71 });

        String text = "71";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0072() {
        String expected = new String(new char[] { (char) 0x72 });

        String text = "72";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0073() {
        String expected = new String(new char[] { (char) 0x73 });

        String text = "73";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0074() {
        String expected = new String(new char[] { (char) 0x74 });

        String text = "74";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0075() {
        String expected = new String(new char[] { (char) 0x75 });

        String text = "75";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0076() {
        String expected = new String(new char[] { (char) 0x76 });

        String text = "76";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0077() {
        String expected = new String(new char[] { (char) 0x77 });

        String text = "77";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0078() {
        String expected = new String(new char[] { (char) 0x78 });

        String text = "78";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0079() {
        String expected = new String(new char[] { (char) 0x79 });

        String text = "79";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007a() {
        String expected = new String(new char[] { (char) 0x7a });

        String text = "7a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007b() {
        String expected = new String(new char[] { (char) 0x7b });

        String text = "7b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007c() {
        String expected = new String(new char[] { (char) 0x7c });

        String text = "7c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007d() {
        String expected = new String(new char[] { (char) 0x7d });

        String text = "7d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007e() {
        String expected = new String(new char[] { (char) 0x7e });

        String text = "7e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU007f() {
        String expected = new String(new char[] { (char) 0x7f });

        String text = "7f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0080() {
        String expected = new String(new char[] { (char) 0x80 });

        String text = "80";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0081() {
        String expected = new String(new char[] { (char) 0x81 });

        String text = "81";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0082() {
        String expected = new String(new char[] { (char) 0x82 });

        String text = "82";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0083() {
        String expected = new String(new char[] { (char) 0x83 });

        String text = "83";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0084() {
        String expected = new String(new char[] { (char) 0x84 });

        String text = "84";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0085() {
        String expected = new String(new char[] { (char) 0x85 });

        String text = "85";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0086() {
        String expected = new String(new char[] { (char) 0x86 });

        String text = "86";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0087() {
        String expected = new String(new char[] { (char) 0x87 });

        String text = "87";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0088() {
        String expected = new String(new char[] { (char) 0x88 });

        String text = "88";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0089() {
        String expected = new String(new char[] { (char) 0x89 });

        String text = "89";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008a() {
        String expected = new String(new char[] { (char) 0x8a });

        String text = "8a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008b() {
        String expected = new String(new char[] { (char) 0x8b });

        String text = "8b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008c() {
        String expected = new String(new char[] { (char) 0x8c });

        String text = "8c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008d() {
        String expected = new String(new char[] { (char) 0x8d });

        String text = "8d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008e() {
        String expected = new String(new char[] { (char) 0x8e });

        String text = "8e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU008f() {
        String expected = new String(new char[] { (char) 0x8f });

        String text = "8f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0090() {
        String expected = new String(new char[] { (char) 0x90 });

        String text = "90";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0091() {
        String expected = new String(new char[] { (char) 0x91 });

        String text = "91";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0092() {
        String expected = new String(new char[] { (char) 0x92 });

        String text = "92";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0093() {
        String expected = new String(new char[] { (char) 0x93 });

        String text = "93";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0094() {
        String expected = new String(new char[] { (char) 0x94 });

        String text = "94";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0095() {
        String expected = new String(new char[] { (char) 0x95 });

        String text = "95";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0096() {
        String expected = new String(new char[] { (char) 0x96 });

        String text = "96";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0097() {
        String expected = new String(new char[] { (char) 0x97 });

        String text = "97";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0098() {
        String expected = new String(new char[] { (char) 0x98 });

        String text = "98";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU0099() {
        String expected = new String(new char[] { (char) 0x99 });

        String text = "99";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009a() {
        String expected = new String(new char[] { (char) 0x9a });

        String text = "9a";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009b() {
        String expected = new String(new char[] { (char) 0x9b });

        String text = "9b";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009c() {
        String expected = new String(new char[] { (char) 0x9c });

        String text = "9c";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009d() {
        String expected = new String(new char[] { (char) 0x9d });

        String text = "9d";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009e() {
        String expected = new String(new char[] { (char) 0x9e });

        String text = "9e";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU009f() {
        String expected = new String(new char[] { (char) 0x9f });

        String text = "9f";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a0() {
        String expected = new String(new char[] { (char) 0xa0 });

        String text = "a0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a1() {
        String expected = new String(new char[] { (char) 0xa1 });

        String text = "a1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a2() {
        String expected = new String(new char[] { (char) 0xa2 });

        String text = "a2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a3() {
        String expected = new String(new char[] { (char) 0xa3 });

        String text = "a3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a4() {
        String expected = new String(new char[] { (char) 0xa4 });

        String text = "a4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a5() {
        String expected = new String(new char[] { (char) 0xa5 });

        String text = "a5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a6() {
        String expected = new String(new char[] { (char) 0xa6 });

        String text = "a6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a7() {
        String expected = new String(new char[] { (char) 0xa7 });

        String text = "a7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a8() {
        String expected = new String(new char[] { (char) 0xa8 });

        String text = "a8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00a9() {
        String expected = new String(new char[] { (char) 0xa9 });

        String text = "a9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00aa() {
        String expected = new String(new char[] { (char) 0xaa });

        String text = "aa";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ab() {
        String expected = new String(new char[] { (char) 0xab });

        String text = "ab";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ac() {
        String expected = new String(new char[] { (char) 0xac });

        String text = "ac";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ad() {
        String expected = new String(new char[] { (char) 0xad });

        String text = "ad";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ae() {
        String expected = new String(new char[] { (char) 0xae });

        String text = "ae";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00af() {
        String expected = new String(new char[] { (char) 0xaf });

        String text = "af";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b0() {
        String expected = new String(new char[] { (char) 0xb0 });

        String text = "b0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b1() {
        String expected = new String(new char[] { (char) 0xb1 });

        String text = "b1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b2() {
        String expected = new String(new char[] { (char) 0xb2 });

        String text = "b2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b3() {
        String expected = new String(new char[] { (char) 0xb3 });

        String text = "b3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b4() {
        String expected = new String(new char[] { (char) 0xb4 });

        String text = "b4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b5() {
        String expected = new String(new char[] { (char) 0xb5 });

        String text = "b5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b6() {
        String expected = new String(new char[] { (char) 0xb6 });

        String text = "b6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b7() {
        String expected = new String(new char[] { (char) 0xb7 });

        String text = "b7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b8() {
        String expected = new String(new char[] { (char) 0xb8 });

        String text = "b8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00b9() {
        String expected = new String(new char[] { (char) 0xb9 });

        String text = "b9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ba() {
        String expected = new String(new char[] { (char) 0xba });

        String text = "ba";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00bb() {
        String expected = new String(new char[] { (char) 0xbb });

        String text = "bb";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00bc() {
        String expected = new String(new char[] { (char) 0xbc });

        String text = "bc";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00bd() {
        String expected = new String(new char[] { (char) 0xbd });

        String text = "bd";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00be() {
        String expected = new String(new char[] { (char) 0xbe });

        String text = "be";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00bf() {
        String expected = new String(new char[] { (char) 0xbf });

        String text = "bf";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c0() {
        String expected = new String(new char[] { (char) 0xc0 });

        String text = "c0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c1() {
        String expected = new String(new char[] { (char) 0xc1 });

        String text = "c1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c2() {
        String expected = new String(new char[] { (char) 0xc2 });

        String text = "c2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c3() {
        String expected = new String(new char[] { (char) 0xc3 });

        String text = "c3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c4() {
        String expected = new String(new char[] { (char) 0xc4 });

        String text = "c4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c5() {
        String expected = new String(new char[] { (char) 0xc5 });

        String text = "c5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c6() {
        String expected = new String(new char[] { (char) 0xc6 });

        String text = "c6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c7() {
        String expected = new String(new char[] { (char) 0xc7 });

        String text = "c7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c8() {
        String expected = new String(new char[] { (char) 0xc8 });

        String text = "c8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00c9() {
        String expected = new String(new char[] { (char) 0xc9 });

        String text = "c9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ca() {
        String expected = new String(new char[] { (char) 0xca });

        String text = "ca";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00cb() {
        String expected = new String(new char[] { (char) 0xcb });

        String text = "cb";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00cc() {
        String expected = new String(new char[] { (char) 0xcc });

        String text = "cc";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00cd() {
        String expected = new String(new char[] { (char) 0xcd });

        String text = "cd";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ce() {
        String expected = new String(new char[] { (char) 0xce });

        String text = "ce";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00cf() {
        String expected = new String(new char[] { (char) 0xcf });

        String text = "cf";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d0() {
        String expected = new String(new char[] { (char) 0xd0 });

        String text = "d0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d1() {
        String expected = new String(new char[] { (char) 0xd1 });

        String text = "d1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d2() {
        String expected = new String(new char[] { (char) 0xd2 });

        String text = "d2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d3() {
        String expected = new String(new char[] { (char) 0xd3 });

        String text = "d3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d4() {
        String expected = new String(new char[] { (char) 0xd4 });

        String text = "d4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d5() {
        String expected = new String(new char[] { (char) 0xd5 });

        String text = "d5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d6() {
        String expected = new String(new char[] { (char) 0xd6 });

        String text = "d6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d7() {
        String expected = new String(new char[] { (char) 0xd7 });

        String text = "d7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d8() {
        String expected = new String(new char[] { (char) 0xd8 });

        String text = "d8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00d9() {
        String expected = new String(new char[] { (char) 0xd9 });

        String text = "d9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00da() {
        String expected = new String(new char[] { (char) 0xda });

        String text = "da";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00db() {
        String expected = new String(new char[] { (char) 0xdb });

        String text = "db";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00dc() {
        String expected = new String(new char[] { (char) 0xdc });

        String text = "dc";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00dd() {
        String expected = new String(new char[] { (char) 0xdd });

        String text = "dd";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00de() {
        String expected = new String(new char[] { (char) 0xde });

        String text = "de";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00df() {
        String expected = new String(new char[] { (char) 0xdf });

        String text = "df";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e0() {
        String expected = new String(new char[] { (char) 0xe0 });

        String text = "e0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e1() {
        String expected = new String(new char[] { (char) 0xe1 });

        String text = "e1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e2() {
        String expected = new String(new char[] { (char) 0xe2 });

        String text = "e2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e3() {
        String expected = new String(new char[] { (char) 0xe3 });

        String text = "e3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e4() {
        String expected = new String(new char[] { (char) 0xe4 });

        String text = "e4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e5() {
        String expected = new String(new char[] { (char) 0xe5 });

        String text = "e5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e6() {
        String expected = new String(new char[] { (char) 0xe6 });

        String text = "e6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e7() {
        String expected = new String(new char[] { (char) 0xe7 });

        String text = "e7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e8() {
        String expected = new String(new char[] { (char) 0xe8 });

        String text = "e8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00e9() {
        String expected = new String(new char[] { (char) 0xe9 });

        String text = "e9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ea() {
        String expected = new String(new char[] { (char) 0xea });

        String text = "ea";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00eb() {
        String expected = new String(new char[] { (char) 0xeb });

        String text = "eb";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ec() {
        String expected = new String(new char[] { (char) 0xec });

        String text = "ec";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ed() {
        String expected = new String(new char[] { (char) 0xed });

        String text = "ed";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ee() {
        String expected = new String(new char[] { (char) 0xee });

        String text = "ee";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ef() {
        String expected = new String(new char[] { (char) 0xef });

        String text = "ef";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f0() {
        String expected = new String(new char[] { (char) 0xf0 });

        String text = "f0";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f1() {
        String expected = new String(new char[] { (char) 0xf1 });

        String text = "f1";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f2() {
        String expected = new String(new char[] { (char) 0xf2 });

        String text = "f2";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f3() {
        String expected = new String(new char[] { (char) 0xf3 });

        String text = "f3";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f4() {
        String expected = new String(new char[] { (char) 0xf4 });

        String text = "f4";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f5() {
        String expected = new String(new char[] { (char) 0xf5 });

        String text = "f5";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f6() {
        String expected = new String(new char[] { (char) 0xf6 });

        String text = "f6";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f7() {
        String expected = new String(new char[] { (char) 0xf7 });

        String text = "f7";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f8() {
        String expected = new String(new char[] { (char) 0xf8 });

        String text = "f8";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00f9() {
        String expected = new String(new char[] { (char) 0xf9 });

        String text = "f9";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00fa() {
        String expected = new String(new char[] { (char) 0xfa });

        String text = "fa";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00fb() {
        String expected = new String(new char[] { (char) 0xfb });

        String text = "fb";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00fc() {
        String expected = new String(new char[] { (char) 0xfc });

        String text = "fc";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00fd() {
        String expected = new String(new char[] { (char) 0xfd });

        String text = "fd";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00fe() {
        String expected = new String(new char[] { (char) 0xfe });

        String text = "fe";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testDecodeU00ff() {
        String expected = new String(new char[] { (char) 0xff });

        String text = "ff";

        String observed = Util.decode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeMulticharacter() {
        String expected = "00ff";

        String text = new String(new char[] {(char) 0x00, (char) 0xff });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0000() {
        String expected = "00";

        String text = new String(new char[] { (char) 0x00 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0001() {
        String expected = "01";

        String text = new String(new char[] { (char) 0x01 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0002() {
        String expected = "02";

        String text = new String(new char[] { (char) 0x02 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0003() {
        String expected = "03";

        String text = new String(new char[] { (char) 0x03 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0004() {
        String expected = "04";

        String text = new String(new char[] { (char) 0x04 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0005() {
        String expected = "05";

        String text = new String(new char[] { (char) 0x05 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0006() {
        String expected = "06";

        String text = new String(new char[] { (char) 0x06 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0007() {
        String expected = "07";

        String text = new String(new char[] { (char) 0x07 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0008() {
        String expected = "08";

        String text = new String(new char[] { (char) 0x08 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0009() {
        String expected = "09";

        String text = new String(new char[] { (char) 0x09 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000a() {
        String expected = "0a";

        String text = new String(new char[] { (char) 0x0a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000b() {
        String expected = "0b";

        String text = new String(new char[] { (char) 0x0b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000c() {
        String expected = "0c";

        String text = new String(new char[] { (char) 0x0c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000d() {
        String expected = "0d";

        String text = new String(new char[] { (char) 0x0d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000e() {
        String expected = "0e";

        String text = new String(new char[] { (char) 0x0e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU000f() {
        String expected = "0f";

        String text = new String(new char[] { (char) 0x0f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0010() {
        String expected = "10";

        String text = new String(new char[] { (char) 0x10 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0011() {
        String expected = "11";

        String text = new String(new char[] { (char) 0x11 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0012() {
        String expected = "12";

        String text = new String(new char[] { (char) 0x12 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0013() {
        String expected = "13";

        String text = new String(new char[] { (char) 0x13 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0014() {
        String expected = "14";

        String text = new String(new char[] { (char) 0x14 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0015() {
        String expected = "15";

        String text = new String(new char[] { (char) 0x15 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0016() {
        String expected = "16";

        String text = new String(new char[] { (char) 0x16 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0017() {
        String expected = "17";

        String text = new String(new char[] { (char) 0x17 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0018() {
        String expected = "18";

        String text = new String(new char[] { (char) 0x18 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0019() {
        String expected = "19";

        String text = new String(new char[] { (char) 0x19 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001a() {
        String expected = "1a";

        String text = new String(new char[] { (char) 0x1a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001b() {
        String expected = "1b";

        String text = new String(new char[] { (char) 0x1b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001c() {
        String expected = "1c";

        String text = new String(new char[] { (char) 0x1c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001d() {
        String expected = "1d";

        String text = new String(new char[] { (char) 0x1d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001e() {
        String expected = "1e";

        String text = new String(new char[] { (char) 0x1e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU001f() {
        String expected = "1f";

        String text = new String(new char[] { (char) 0x1f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0020() {
        String expected = "20";

        String text = new String(new char[] { (char) 0x20 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0021() {
        String expected = "21";

        String text = new String(new char[] { (char) 0x21 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0022() {
        String expected = "22";

        String text = new String(new char[] { (char) 0x22 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0023() {
        String expected = "23";

        String text = new String(new char[] { (char) 0x23 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0024() {
        String expected = "24";

        String text = new String(new char[] { (char) 0x24 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0025() {
        String expected = "25";

        String text = new String(new char[] { (char) 0x25 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0026() {
        String expected = "26";

        String text = new String(new char[] { (char) 0x26 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0027() {
        String expected = "27";

        String text = new String(new char[] { (char) 0x27 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0028() {
        String expected = "28";

        String text = new String(new char[] { (char) 0x28 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0029() {
        String expected = "29";

        String text = new String(new char[] { (char) 0x29 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002a() {
        String expected = "2a";

        String text = new String(new char[] { (char) 0x2a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002b() {
        String expected = "2b";

        String text = new String(new char[] { (char) 0x2b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002c() {
        String expected = "2c";

        String text = new String(new char[] { (char) 0x2c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002d() {
        String expected = "2d";

        String text = new String(new char[] { (char) 0x2d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002e() {
        String expected = "2e";

        String text = new String(new char[] { (char) 0x2e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU002f() {
        String expected = "2f";

        String text = new String(new char[] { (char) 0x2f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0030() {
        String expected = "30";

        String text = new String(new char[] { (char) 0x30 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0031() {
        String expected = "31";

        String text = new String(new char[] { (char) 0x31 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0032() {
        String expected = "32";

        String text = new String(new char[] { (char) 0x32 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0033() {
        String expected = "33";

        String text = new String(new char[] { (char) 0x33 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0034() {
        String expected = "34";

        String text = new String(new char[] { (char) 0x34 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0035() {
        String expected = "35";

        String text = new String(new char[] { (char) 0x35 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0036() {
        String expected = "36";

        String text = new String(new char[] { (char) 0x36 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0037() {
        String expected = "37";

        String text = new String(new char[] { (char) 0x37 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0038() {
        String expected = "38";

        String text = new String(new char[] { (char) 0x38 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0039() {
        String expected = "39";

        String text = new String(new char[] { (char) 0x39 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003a() {
        String expected = "3a";

        String text = new String(new char[] { (char) 0x3a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003b() {
        String expected = "3b";

        String text = new String(new char[] { (char) 0x3b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003c() {
        String expected = "3c";

        String text = new String(new char[] { (char) 0x3c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003d() {
        String expected = "3d";

        String text = new String(new char[] { (char) 0x3d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003e() {
        String expected = "3e";

        String text = new String(new char[] { (char) 0x3e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU003f() {
        String expected = "3f";

        String text = new String(new char[] { (char) 0x3f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0040() {
        String expected = "40";

        String text = new String(new char[] { (char) 0x40 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0041() {
        String expected = "41";

        String text = new String(new char[] { (char) 0x41 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0042() {
        String expected = "42";

        String text = new String(new char[] { (char) 0x42 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0043() {
        String expected = "43";

        String text = new String(new char[] { (char) 0x43 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0044() {
        String expected = "44";

        String text = new String(new char[] { (char) 0x44 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0045() {
        String expected = "45";

        String text = new String(new char[] { (char) 0x45 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0046() {
        String expected = "46";

        String text = new String(new char[] { (char) 0x46 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0047() {
        String expected = "47";

        String text = new String(new char[] { (char) 0x47 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0048() {
        String expected = "48";

        String text = new String(new char[] { (char) 0x48 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0049() {
        String expected = "49";

        String text = new String(new char[] { (char) 0x49 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004a() {
        String expected = "4a";

        String text = new String(new char[] { (char) 0x4a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004b() {
        String expected = "4b";

        String text = new String(new char[] { (char) 0x4b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004c() {
        String expected = "4c";

        String text = new String(new char[] { (char) 0x4c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004d() {
        String expected = "4d";

        String text = new String(new char[] { (char) 0x4d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004e() {
        String expected = "4e";

        String text = new String(new char[] { (char) 0x4e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU004f() {
        String expected = "4f";

        String text = new String(new char[] { (char) 0x4f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0050() {
        String expected = "50";

        String text = new String(new char[] { (char) 0x50 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0051() {
        String expected = "51";

        String text = new String(new char[] { (char) 0x51 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0052() {
        String expected = "52";

        String text = new String(new char[] { (char) 0x52 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0053() {
        String expected = "53";

        String text = new String(new char[] { (char) 0x53 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0054() {
        String expected = "54";

        String text = new String(new char[] { (char) 0x54 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0055() {
        String expected = "55";

        String text = new String(new char[] { (char) 0x55 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0056() {
        String expected = "56";

        String text = new String(new char[] { (char) 0x56 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0057() {
        String expected = "57";

        String text = new String(new char[] { (char) 0x57 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0058() {
        String expected = "58";

        String text = new String(new char[] { (char) 0x58 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0059() {
        String expected = "59";

        String text = new String(new char[] { (char) 0x59 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005a() {
        String expected = "5a";

        String text = new String(new char[] { (char) 0x5a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005b() {
        String expected = "5b";

        String text = new String(new char[] { (char) 0x5b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005c() {
        String expected = "5c";

        String text = new String(new char[] { (char) 0x5c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005d() {
        String expected = "5d";

        String text = new String(new char[] { (char) 0x5d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005e() {
        String expected = "5e";

        String text = new String(new char[] { (char) 0x5e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU005f() {
        String expected = "5f";

        String text = new String(new char[] { (char) 0x5f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0060() {
        String expected = "60";

        String text = new String(new char[] { (char) 0x60 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0061() {
        String expected = "61";

        String text = new String(new char[] { (char) 0x61 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0062() {
        String expected = "62";

        String text = new String(new char[] { (char) 0x62 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0063() {
        String expected = "63";

        String text = new String(new char[] { (char) 0x63 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0064() {
        String expected = "64";

        String text = new String(new char[] { (char) 0x64 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0065() {
        String expected = "65";

        String text = new String(new char[] { (char) 0x65 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0066() {
        String expected = "66";

        String text = new String(new char[] { (char) 0x66 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0067() {
        String expected = "67";

        String text = new String(new char[] { (char) 0x67 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0068() {
        String expected = "68";

        String text = new String(new char[] { (char) 0x68 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0069() {
        String expected = "69";

        String text = new String(new char[] { (char) 0x69 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006a() {
        String expected = "6a";

        String text = new String(new char[] { (char) 0x6a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006b() {
        String expected = "6b";

        String text = new String(new char[] { (char) 0x6b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006c() {
        String expected = "6c";

        String text = new String(new char[] { (char) 0x6c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006d() {
        String expected = "6d";

        String text = new String(new char[] { (char) 0x6d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006e() {
        String expected = "6e";

        String text = new String(new char[] { (char) 0x6e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU006f() {
        String expected = "6f";

        String text = new String(new char[] { (char) 0x6f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0070() {
        String expected = "70";

        String text = new String(new char[] { (char) 0x70 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0071() {
        String expected = "71";

        String text = new String(new char[] { (char) 0x71 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0072() {
        String expected = "72";

        String text = new String(new char[] { (char) 0x72 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0073() {
        String expected = "73";

        String text = new String(new char[] { (char) 0x73 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0074() {
        String expected = "74";

        String text = new String(new char[] { (char) 0x74 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0075() {
        String expected = "75";

        String text = new String(new char[] { (char) 0x75 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0076() {
        String expected = "76";

        String text = new String(new char[] { (char) 0x76 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0077() {
        String expected = "77";

        String text = new String(new char[] { (char) 0x77 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0078() {
        String expected = "78";

        String text = new String(new char[] { (char) 0x78 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0079() {
        String expected = "79";

        String text = new String(new char[] { (char) 0x79 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007a() {
        String expected = "7a";

        String text = new String(new char[] { (char) 0x7a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007b() {
        String expected = "7b";

        String text = new String(new char[] { (char) 0x7b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007c() {
        String expected = "7c";

        String text = new String(new char[] { (char) 0x7c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007d() {
        String expected = "7d";

        String text = new String(new char[] { (char) 0x7d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007e() {
        String expected = "7e";

        String text = new String(new char[] { (char) 0x7e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU007f() {
        String expected = "7f";

        String text = new String(new char[] { (char) 0x7f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0080() {
        String expected = "80";

        String text = new String(new char[] { (char) 0x80 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0081() {
        String expected = "81";

        String text = new String(new char[] { (char) 0x81 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0082() {
        String expected = "82";

        String text = new String(new char[] { (char) 0x82 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0083() {
        String expected = "83";

        String text = new String(new char[] { (char) 0x83 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0084() {
        String expected = "84";

        String text = new String(new char[] { (char) 0x84 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0085() {
        String expected = "85";

        String text = new String(new char[] { (char) 0x85 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0086() {
        String expected = "86";

        String text = new String(new char[] { (char) 0x86 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0087() {
        String expected = "87";

        String text = new String(new char[] { (char) 0x87 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0088() {
        String expected = "88";

        String text = new String(new char[] { (char) 0x88 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0089() {
        String expected = "89";

        String text = new String(new char[] { (char) 0x89 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008a() {
        String expected = "8a";

        String text = new String(new char[] { (char) 0x8a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008b() {
        String expected = "8b";

        String text = new String(new char[] { (char) 0x8b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008c() {
        String expected = "8c";

        String text = new String(new char[] { (char) 0x8c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008d() {
        String expected = "8d";

        String text = new String(new char[] { (char) 0x8d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008e() {
        String expected = "8e";

        String text = new String(new char[] { (char) 0x8e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU008f() {
        String expected = "8f";

        String text = new String(new char[] { (char) 0x8f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0090() {
        String expected = "90";

        String text = new String(new char[] { (char) 0x90 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0091() {
        String expected = "91";

        String text = new String(new char[] { (char) 0x91 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0092() {
        String expected = "92";

        String text = new String(new char[] { (char) 0x92 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0093() {
        String expected = "93";

        String text = new String(new char[] { (char) 0x93 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0094() {
        String expected = "94";

        String text = new String(new char[] { (char) 0x94 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0095() {
        String expected = "95";

        String text = new String(new char[] { (char) 0x95 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0096() {
        String expected = "96";

        String text = new String(new char[] { (char) 0x96 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0097() {
        String expected = "97";

        String text = new String(new char[] { (char) 0x97 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0098() {
        String expected = "98";

        String text = new String(new char[] { (char) 0x98 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU0099() {
        String expected = "99";

        String text = new String(new char[] { (char) 0x99 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009a() {
        String expected = "9a";

        String text = new String(new char[] { (char) 0x9a });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009b() {
        String expected = "9b";

        String text = new String(new char[] { (char) 0x9b });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009c() {
        String expected = "9c";

        String text = new String(new char[] { (char) 0x9c });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009d() {
        String expected = "9d";

        String text = new String(new char[] { (char) 0x9d });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009e() {
        String expected = "9e";

        String text = new String(new char[] { (char) 0x9e });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU009f() {
        String expected = "9f";

        String text = new String(new char[] { (char) 0x9f });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a0() {
        String expected = "a0";

        String text = new String(new char[] { (char) 0xa0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a1() {
        String expected = "a1";

        String text = new String(new char[] { (char) 0xa1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a2() {
        String expected = "a2";

        String text = new String(new char[] { (char) 0xa2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a3() {
        String expected = "a3";

        String text = new String(new char[] { (char) 0xa3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a4() {
        String expected = "a4";

        String text = new String(new char[] { (char) 0xa4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a5() {
        String expected = "a5";

        String text = new String(new char[] { (char) 0xa5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a6() {
        String expected = "a6";

        String text = new String(new char[] { (char) 0xa6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a7() {
        String expected = "a7";

        String text = new String(new char[] { (char) 0xa7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a8() {
        String expected = "a8";

        String text = new String(new char[] { (char) 0xa8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00a9() {
        String expected = "a9";

        String text = new String(new char[] { (char) 0xa9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00aa() {
        String expected = "aa";

        String text = new String(new char[] { (char) 0xaa });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ab() {
        String expected = "ab";

        String text = new String(new char[] { (char) 0xab });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ac() {
        String expected = "ac";

        String text = new String(new char[] { (char) 0xac });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ad() {
        String expected = "ad";

        String text = new String(new char[] { (char) 0xad });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ae() {
        String expected = "ae";

        String text = new String(new char[] { (char) 0xae });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00af() {
        String expected = "af";

        String text = new String(new char[] { (char) 0xaf });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b0() {
        String expected = "b0";

        String text = new String(new char[] { (char) 0xb0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b1() {
        String expected = "b1";

        String text = new String(new char[] { (char) 0xb1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b2() {
        String expected = "b2";

        String text = new String(new char[] { (char) 0xb2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b3() {
        String expected = "b3";

        String text = new String(new char[] { (char) 0xb3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b4() {
        String expected = "b4";

        String text = new String(new char[] { (char) 0xb4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b5() {
        String expected = "b5";

        String text = new String(new char[] { (char) 0xb5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b6() {
        String expected = "b6";

        String text = new String(new char[] { (char) 0xb6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b7() {
        String expected = "b7";

        String text = new String(new char[] { (char) 0xb7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b8() {
        String expected = "b8";

        String text = new String(new char[] { (char) 0xb8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00b9() {
        String expected = "b9";

        String text = new String(new char[] { (char) 0xb9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ba() {
        String expected = "ba";

        String text = new String(new char[] { (char) 0xba });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00bb() {
        String expected = "bb";

        String text = new String(new char[] { (char) 0xbb });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00bc() {
        String expected = "bc";

        String text = new String(new char[] { (char) 0xbc });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00bd() {
        String expected = "bd";

        String text = new String(new char[] { (char) 0xbd });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00be() {
        String expected = "be";

        String text = new String(new char[] { (char) 0xbe });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00bf() {
        String expected = "bf";

        String text = new String(new char[] { (char) 0xbf });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c0() {
        String expected = "c0";

        String text = new String(new char[] { (char) 0xc0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c1() {
        String expected = "c1";

        String text = new String(new char[] { (char) 0xc1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c2() {
        String expected = "c2";

        String text = new String(new char[] { (char) 0xc2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c3() {
        String expected = "c3";

        String text = new String(new char[] { (char) 0xc3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c4() {
        String expected = "c4";

        String text = new String(new char[] { (char) 0xc4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c5() {
        String expected = "c5";

        String text = new String(new char[] { (char) 0xc5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c6() {
        String expected = "c6";

        String text = new String(new char[] { (char) 0xc6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c7() {
        String expected = "c7";

        String text = new String(new char[] { (char) 0xc7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c8() {
        String expected = "c8";

        String text = new String(new char[] { (char) 0xc8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00c9() {
        String expected = "c9";

        String text = new String(new char[] { (char) 0xc9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ca() {
        String expected = "ca";

        String text = new String(new char[] { (char) 0xca });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00cb() {
        String expected = "cb";

        String text = new String(new char[] { (char) 0xcb });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00cc() {
        String expected = "cc";

        String text = new String(new char[] { (char) 0xcc });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00cd() {
        String expected = "cd";

        String text = new String(new char[] { (char) 0xcd });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ce() {
        String expected = "ce";

        String text = new String(new char[] { (char) 0xce });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00cf() {
        String expected = "cf";

        String text = new String(new char[] { (char) 0xcf });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d0() {
        String expected = "d0";

        String text = new String(new char[] { (char) 0xd0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d1() {
        String expected = "d1";

        String text = new String(new char[] { (char) 0xd1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d2() {
        String expected = "d2";

        String text = new String(new char[] { (char) 0xd2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d3() {
        String expected = "d3";

        String text = new String(new char[] { (char) 0xd3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d4() {
        String expected = "d4";

        String text = new String(new char[] { (char) 0xd4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d5() {
        String expected = "d5";

        String text = new String(new char[] { (char) 0xd5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d6() {
        String expected = "d6";

        String text = new String(new char[] { (char) 0xd6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d7() {
        String expected = "d7";

        String text = new String(new char[] { (char) 0xd7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d8() {
        String expected = "d8";

        String text = new String(new char[] { (char) 0xd8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00d9() {
        String expected = "d9";

        String text = new String(new char[] { (char) 0xd9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00da() {
        String expected = "da";

        String text = new String(new char[] { (char) 0xda });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00db() {
        String expected = "db";

        String text = new String(new char[] { (char) 0xdb });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00dc() {
        String expected = "dc";

        String text = new String(new char[] { (char) 0xdc });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00dd() {
        String expected = "dd";

        String text = new String(new char[] { (char) 0xdd });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00de() {
        String expected = "de";

        String text = new String(new char[] { (char) 0xde });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00df() {
        String expected = "df";

        String text = new String(new char[] { (char) 0xdf });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e0() {
        String expected = "e0";

        String text = new String(new char[] { (char) 0xe0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e1() {
        String expected = "e1";

        String text = new String(new char[] { (char) 0xe1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e2() {
        String expected = "e2";

        String text = new String(new char[] { (char) 0xe2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e3() {
        String expected = "e3";

        String text = new String(new char[] { (char) 0xe3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e4() {
        String expected = "e4";

        String text = new String(new char[] { (char) 0xe4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e5() {
        String expected = "e5";

        String text = new String(new char[] { (char) 0xe5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e6() {
        String expected = "e6";

        String text = new String(new char[] { (char) 0xe6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e7() {
        String expected = "e7";

        String text = new String(new char[] { (char) 0xe7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e8() {
        String expected = "e8";

        String text = new String(new char[] { (char) 0xe8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00e9() {
        String expected = "e9";

        String text = new String(new char[] { (char) 0xe9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ea() {
        String expected = "ea";

        String text = new String(new char[] { (char) 0xea });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00eb() {
        String expected = "eb";

        String text = new String(new char[] { (char) 0xeb });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ec() {
        String expected = "ec";

        String text = new String(new char[] { (char) 0xec });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ed() {
        String expected = "ed";

        String text = new String(new char[] { (char) 0xed });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ee() {
        String expected = "ee";

        String text = new String(new char[] { (char) 0xee });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ef() {
        String expected = "ef";

        String text = new String(new char[] { (char) 0xef });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f0() {
        String expected = "f0";

        String text = new String(new char[] { (char) 0xf0 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f1() {
        String expected = "f1";

        String text = new String(new char[] { (char) 0xf1 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f2() {
        String expected = "f2";

        String text = new String(new char[] { (char) 0xf2 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f3() {
        String expected = "f3";

        String text = new String(new char[] { (char) 0xf3 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f4() {
        String expected = "f4";

        String text = new String(new char[] { (char) 0xf4 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f5() {
        String expected = "f5";

        String text = new String(new char[] { (char) 0xf5 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f6() {
        String expected = "f6";

        String text = new String(new char[] { (char) 0xf6 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f7() {
        String expected = "f7";

        String text = new String(new char[] { (char) 0xf7 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f8() {
        String expected = "f8";

        String text = new String(new char[] { (char) 0xf8 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00f9() {
        String expected = "f9";

        String text = new String(new char[] { (char) 0xf9 });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00fa() {
        String expected = "fa";

        String text = new String(new char[] { (char) 0xfa });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00fb() {
        String expected = "fb";

        String text = new String(new char[] { (char) 0xfb });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00fc() {
        String expected = "fc";

        String text = new String(new char[] { (char) 0xfc });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00fd() {
        String expected = "fd";

        String text = new String(new char[] { (char) 0xfd });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00fe() {
        String expected = "fe";

        String text = new String(new char[] { (char) 0xfe });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeU00ff() {
        String expected = "ff";

        String text = new String(new char[] { (char) 0xff });

        String observed = Util.encode(text);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testGetDatabaseDir() {
        Assert.fail("to be implemented");
    }
}
