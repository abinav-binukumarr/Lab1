// BinaryTest.java
package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest
{
    /**
     * Test add function with equal-length binary numbers
     */
    @Test
    public void testAddEqualLength() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0101");
        Binary result = Binary.add(binary1, binary2);
        assertEquals("1111", result.getValue());
    }

    /**
     * Test add function with binary numbers of different lengths
     */
    @Test
    public void testAddDifferentLength() {
        Binary binary1 = new Binary("101");
        Binary binary2 = new Binary("11001");
        Binary result = Binary.add(binary1, binary2);
        assertEquals("11110", result.getValue());
    }

    /**
     * Test add function with a binary number and zero
     */
    @Test
    public void testAddWithZero() {
        Binary binary1 = new Binary("1001");
        Binary binary2 = new Binary("0");
        Binary result = Binary.add(binary1, binary2);
        assertEquals("1001", result.getValue());
    }

    /**
     * Test or function with overlapping bits
     */
    @Test
    public void testOrOverlap() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.or(binary1, binary2);
        assertEquals("1110", result.getValue());
    }

    /**
     * Test or function with no overlapping bits
     */
    @Test
    public void testOrNoOverlap() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("0111");
        Binary result = Binary.or(binary1, binary2);
        assertEquals("1111", result.getValue());
    }

    /**
     * Test or function with one binary number as zero
     */
    @Test
    public void testOrWithZero() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.or(binary1, binary2);
        assertEquals("1010", result.getValue());
    }

    /**
     * Test and function with overlapping bits
     */
    @Test
    public void testAndOverlap() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.and(binary1, binary2);
        assertEquals("1000", result.getValue());
    }

    /**
     * Test and function with no overlapping bits
     */
    @Test
    public void testAndNoOverlap() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("0111");
        Binary result = Binary.and(binary1, binary2);
        assertEquals("0", result.getValue());
    }

    /**
     * Test and function with one binary number as zero
     */
    @Test
    public void testAndWithZero() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.and(binary1, binary2);
        assertEquals("0", result.getValue());
    }

    /**
     * Test multiply function with normal numbers
     */
    @Test
    public void testMultiplyNormal() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("10");
        Binary result = Binary.multiply(binary1, binary2);
        assertEquals("110", result.getValue());
    }

    /**
     * Test multiply function with one number as zero
     */
    @Test
    public void testMultiplyWithZero() {
        Binary binary1 = new Binary("101");
        Binary binary2 = new Binary("0");
        Binary result = Binary.multiply(binary1, binary2);
        assertEquals("0", result.getValue());
    }

    /**
     * Test multiply function with one as a factor
     */
    @Test
    public void testMultiplyWithOne() {
        Binary binary1 = new Binary("111");
        Binary binary2 = new Binary("1");
        Binary result = Binary.multiply(binary1, binary2);
        assertEquals("111", result.getValue());
    }
}
