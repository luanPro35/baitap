package Stream;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class AppendPrintWriter {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("test.txt", true));
            writer.println("Dòng mới được thêm vào!");
            writer.close();
            System.out.println("Ghi thêm thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

