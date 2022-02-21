package org.pg4200.ex11;

import org.junit.jupiter.api.Test;
import org.pg4200.les11.Huffman;
import org.pg4200.les11.HuffmanTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HuffmanIsoTest {
    private double checkCompressAndDecompress(Huffman huffman, String text, String charset) {
        byte[] compressed = huffman.compress(text);
        String res = huffman.decompress(compressed);

        assertEquals(text, res);

        System.out.println(huffman.getStatistics(text));

        int originalLength = text.getBytes(Charset.forName(charset)).length;

        double ratio = (double) compressed.length / (double) originalLength;

        System.out.println("Charset   : " + charset);
        System.out.println("Org size  : " + originalLength);
        System.out.println("Comp size : " + compressed.length);
        System.out.println("Ratio     : " + ratio);

        return ratio;
    }

    @Test
    public void testCompareOnShortNorwegianSentence() {
        String text = "Jeg ønsker å få en god karakter i denne eksamenen";

        Huffman utf = new Huffman();
        Huffman iso = new HuffmanIso();

        double resUTF = checkCompressAndDecompress(utf, text, "utf-8");
        double resISO = checkCompressAndDecompress(iso, text, "utf-8");

        assertTrue(resUTF > resISO);


    }

    @Test
    public void testCompareOnBook() {
        String text = new Scanner(HuffmanTest.class.getResourceAsStream("/compression/odyssey.mb.txt"), "UTF-8").useDelimiter("\\A").next();

        Huffman utf = new Huffman();
        Huffman iso = new HuffmanIso();

        double resUTF = checkCompressAndDecompress(utf, text, "utf-8");
        double resISO = checkCompressAndDecompress(iso, text, "utf-8");

        assertTrue(resISO < resUTF);
        double diff = resUTF - resISO;
        assertTrue(diff < 0.001);
    }
}
