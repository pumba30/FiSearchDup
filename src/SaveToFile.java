import java.io.*;
import java.util.List;

/**
 * Created by pumba30 on 06.12.2014.
 */
public class SaveToFile {

    private BufferedReader bufferedReader;
    private BufferedWriter bw;
    private FileWriter fileWriter;
    private List<File> fileList ;
    private String pathToSave = "C:/ourlist.txt";

    public SaveToFile(List<File> fileList) throws IOException {
        this.fileList = fileList;
        fileWriter = new FileWriter(pathToSave);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    //сохраняем в файл список имен файлов
    public void saveToFile() throws IOException {
        for(File item : fileList){
            String name = item.getName();
            fileWriter.write(name + "\r\n");
        }
        fileWriter.close();
    }


}
