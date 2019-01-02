package ru.job4j.inputoutput;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class CheckByteStream {

    public boolean isNumber (InputStream in) throws IOException {
        boolean result = false;
        try {
            byte[] number = new byte[4];
            in.read(number);
            ByteBuffer bb = ByteBuffer.wrap(number);
            int numberIn = bb.getInt();
            if (numberIn % 2 == 0) {
                result = true;
            } else {
                result = false;
            }

        } catch (IOException e) {
            throw new IOException();
        } finally {
            in.close();
        }
        return result;
    }

}
