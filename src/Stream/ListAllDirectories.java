package Stream;

import java.io.File;

public class ListAllDirectories {
    public static void listSubDirectories(File folder, String indent) {
        File[] subDirs = folder.listFiles(File::isDirectory);

        if (subDirs != null) {
            for (File dir : subDirs) {
                System.out.println(indent + dir.getName());
                listSubDirectories(dir, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        String path = "C:\\ItextExample\\Thread\\src";
        File folder = new File(path);

        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Danh sách thư mục trong: " + path);
            listSubDirectories(folder, "  ");
        } else {
            System.out.println("Thư mục không tồn tại!");
        }
    }
}

