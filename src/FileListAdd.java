import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pumba30 on 29.11.2014.
 */
public class FileListAdd {
    private File file;
    private List<File> fileList;
    private String pathToDirectory;
    private File[] files;

    public FileListAdd(String pathToDirectory) {
        this.pathToDirectory = pathToDirectory;
        fileList = new ArrayList<File>();
        file = new File(pathToDirectory);
        files = file.listFiles();
    }


    public List<File> getFileList() {
        for (File item : files) {
            if (item.isFile()) {
                fileList.add(item);
            } else {
                File file1 = new File(item.getPath());
                files = file1.listFiles();
                getFileList();
            }
        }
        return fileList;
    }


}
