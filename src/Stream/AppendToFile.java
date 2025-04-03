package Stream;

import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("test.txt", true);
            writer.write("Dòng này được thêm vào");
            writer.close();
            System.out.println("Ghi thêm thành công");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
