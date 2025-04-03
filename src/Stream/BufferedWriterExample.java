package Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Đây là nội dung mới");
            writer.close();
            System.out.println("Ghi thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
