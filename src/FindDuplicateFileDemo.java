import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by pumba30 on 25.12.2014.
 */
public class FindDuplicateFileDemo {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {


        SearchDuplicatesFiles searchDuplicatesFiles = new SearchDuplicatesFiles("c:/testing");
        ArrayList<File> listFoundFiles = searchDuplicatesFiles.getFilesInDirectory();







        System.out.println("Файлы найденные в директории");
        for (File item : listFoundFiles) {
            System.out.println(item);

        }






    }
}
