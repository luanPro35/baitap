package Stream;

import java.io.File;
import java.io.IOException;

public class CanonicalPathExample {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            System.out.println("Địa chỉ file: " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
