package Stream;

import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("test.txt");
            writer.println("Dòng 1: Hello, PrintWriter!");
            writer.println("Dòng 2: Java IO Stream!");
            writer.close();
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
