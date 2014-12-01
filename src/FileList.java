import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pumba30 on 29.11.2014.
 */
public class FileList {

    private List<File> arrayList = new ArrayList<File>();
    private File file;
    private String path;


    public FileList() {

    }

    //получаем список файлов и директорий в заданной директории
    //одновременно с занесением в List только файлов, директории не вносятся
    public void outListFiles(File[] files) throws IOException {
        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {//если директория, читаем список файлов в ней
                    String pathDirectory = item.getPath();
                    File file = new File(pathDirectory);
                    File[] filesArr = file.listFiles();
                    outListFiles(filesArr);
                }
                System.out.println(item.getName());
                if (item.isFile()) {//если файл, то добавляем в список
                    arrayList.add(item);
                }
            }
        } else {
            System.err.println("Array files is null!");
        }
    }
    //вывод файлов, занесенных в List
    public void getListAllFilesArrayList() {
        if (arrayList != null) {
            System.out.println("\nСписок файлов в запрошенной директории: \n");
            for (File item : arrayList) {
                System.out.println(item);
            }
            System.out.println("Length arrayList " + arrayList.size());
        } else {
            System.err.println("Array  is null!");
        }

    }

    //сравним файлы по имени, и, если имя совпдает, один файл оставляем, остальные удвляем
    public void compareFilesByName(){

    }


}
