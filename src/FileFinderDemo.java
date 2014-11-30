
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pumba30 on 27.11.2014.
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();

        FileList fileList = new FileList();
        File file = new File(path);
        File[] files = file.listFiles();


        fileList.outListFiles(files);







    }
}