import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by pumba30 on 29.11.2014.
 */
public class FileListAdd {

    private File file;
    private List<File> fileList;
    private List<File> duplFiles;
    private File[] files;
    private String pathToDirectoty;
    private BufferedReader bufferedReader;
    private String inputLine;
    private Map<String, List<File>> duplFilesByName;

    public FileListAdd() {
        fileList = new ArrayList<File>();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.duplFiles = new ArrayList<File>();


    }




    private List<File> getListFiles(String pathToDirectoty) {
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

    //забираем файлы - дубликаты
    public void getDuplicateFile() throws IOException {
        System.out.println("Введите путь к директории:\n");
        inputLine();
        //TODO проверка ввода - релизовать

        getListFiles(pathToDirectoty);
        outListFilesOnScreen();
        DuplicateFind duplicateFind = new DuplicateFind();
        duplFiles = duplicateFind.toFindPossibleDuplicates(fileList);
        duplicateFind.outOnScreenDuplicatesFiles(duplFiles);

    }

    //забираем дубликаты по имени
    public void getDuplicateFileByName() throws IOException {
        System.out.println("Введите путь к директории:\n");
        inputLine();

        getListFiles(pathToDirectoty);
        outListFilesOnScreen();
        DuplicateFind duplicateFind = new DuplicateFind();
        duplFilesByName = duplicateFind.toFindByName(fileList);
        duplicateFind.outOnScreenDuplFilesByName(duplFilesByName);

    }


    //метод для ввода данных (например пути к директории)
    private void inputLine() throws IOException {
        inputLine = bufferedReader.readLine();
        pathToDirectoty = inputLine;
    }

    //вывод листа файлов заданной директории на экран
    private void outListFilesOnScreen() {
        System.out.println("Список файлов в заданной директории :\n");
        for (File item : fileList) {
            String name = item.getName();
            System.out.println(name);
        }

    }


    //удалить найденные дубликаты
    public void deleteDuplFiles() {
    }


    public String getPathToDirectoty() {
        return pathToDirectoty;
    }

    public void setPathToDirectory(String pathToDirectoty) {
        //TODO реализовать проверку pathToString
        this.pathToDirectoty = pathToDirectoty;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public void setDuplFiles(List<File> duplFiles) {
        this.duplFiles = duplFiles;
    }

    public List<File> getDuplFiles() {
        return duplFiles;
    }


}
