import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by pumba30 on 29.11.2014.
 */
public class FileList {

    private ArrayList<File> arrayList;
    private File file;
    private String path;


    public FileList() {
    }

    public void outListFiles(File[] files) throws IOException {
        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {
                    String pathDirectory = item.getCanonicalPath();
                    System.out.println("\nСписок файлов директории  " + item.getName() + " :");
                    File file = new File(pathDirectory);
                    File[] files1 = file.listFiles();
                    outListFiles(files1);
                    System.out.println("+++++++++ \n");
                }
                System.out.println(item.getName());
                //удаляет файлы
                // item.delete();
            }
        } else {
            System.out.println("Array files is null!");
        }
    }


}
