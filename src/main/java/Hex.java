import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Hex{

    public Hex() {

    }


    public StringBuilder hexConversion(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        int counterByte = 0;
        int value = 0;
        StringBuilder hex = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while ((value = is.read()) != -1) {
            hex.append(String.format("%02X ", value));
            if (counterByte == 15) {
                result.append(hex).append("\n");
                hex.setLength(0);
                counterByte = 0;

            } else {
                counterByte++;
            }
        }

        if (counterByte != 0) {
            for (; counterByte < 16; counterByte++) {
                hex.append("   ");
            }
            result.append(hex).append("\n");
        }
        StringBuilder deneme = result;
        is.close();
        return deneme;
    }



}