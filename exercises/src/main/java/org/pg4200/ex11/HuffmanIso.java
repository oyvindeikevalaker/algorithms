package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;
import org.pg4200.les11.Huffman;

import java.nio.charset.StandardCharsets;

public class HuffmanIso extends Huffman {

    @Override
    protected void writeTrie(Node node, BitWriter buffer) {
        if (node.isLeaf()) {
            buffer.write(true);
            byte[] isoByte = ("" + node.ch).getBytes(StandardCharsets.ISO_8859_1);
            buffer.write(isoByte[0]);
            return;
        }

        buffer.write(false);
        writeTrie(node.left, buffer);
        writeTrie(node.right, buffer);
    }

    @Override
    protected Node readTrie(BitReader buffer) {
        boolean isLeaf = buffer.readBoolean();

        if (isLeaf) {
            byte isoByte = buffer.readByte();
            char c = new String(new byte[]{isoByte}, StandardCharsets.ISO_8859_1).charAt(0);
            return new Node(c, -1, null, null);
        } else {
            return new Node(null, -1, readTrie(buffer), readTrie(buffer));
        }
    }
}
