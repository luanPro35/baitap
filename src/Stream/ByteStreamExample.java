package Stream;

import java.io.FileInputStream;
import java.io.FileWriter;

public class ByteStreamExample {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("test.txt");
            writer.write("Hello, tôi là Lê Quang Luân");
            writer.write("Sinh viên");
            writer.close();
            System.out.println("Ghi file thành công");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
