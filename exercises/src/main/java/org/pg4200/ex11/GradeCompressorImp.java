package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class GradeCompressorImp implements GradeCompressor {
    @Override
    public byte[] compress(String idsAndGrades) {
        BitWriter writer = new BitWriter();
        String id = "";

        for (int i = 0; i < idsAndGrades.length(); i++) {
            char c = idsAndGrades.charAt(i);
            if (c >= '0' && c <= '9') {
                id += c;
            } else if (c >= 'A' && c <= 'F') {
                writer.write(Integer.parseInt(id), 9);
                writer.write(c - 'A', 3);
                id = "";
            }
        }
        return writer.extract();

//        writer.write(idsAndGrades.length());
//
//        for (int i = 0; i < idsAndGrades.length(); i++) {
//            char c = idsAndGrades.charAt(i)
//                    if(c=="A") { //000
//                        writer.write(false);
//                        writer.write(false);
//                        writer.write(false);
//                    } else if(c=="B"){ //001
//                        writer.write(false);
//                        writer.write(false);
//                        writer.write(true);
//                    } else if
//        }
    }

    @Override
    public String decompress(byte[] data) {
        BitReader reader = new BitReader(data);
        int entries = (data.length * 8) / 12;
        String grades = "";

        for (int i = 0; i < entries; i++) {
            grades += reader.readInt(9);
            grades += (char) ('A' + reader.readInt(3));
        }


        return grades;
    }
}
