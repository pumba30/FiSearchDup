import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by pumba30 on 29.11.2014.
 */
public class FileListAdd {
    private File file;
    private List<File> fileList;
    private File[] files;
    private String pathToDirectoty;

    public FileListAdd() {
        fileList = new ArrayList<File>();
    }

    public List<File> getListFiles(String pathToDirectoty) {
        file = new File(pathToDirectoty);
        files = file.listFiles(); //получили массив списка файлов заданной директории
        for (File item : files) {
            if (!item.isDirectory()) {
                fileList.add(item);
            } else {
                getListFiles(item.getPath());
            }
        }
        return fileList;
    }

    public String getPathToDirectoty() {
        return pathToDirectoty;
    }

    public void setPathToDirectory(String pathToDirectoty) {
        //TODO реализовать проверку pathToString
        this.pathToDirectoty = pathToDirectoty;
    }
}
