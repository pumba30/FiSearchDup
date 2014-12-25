import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pumba30 on 11.12.2014.
 */
public class AddListFilesToSearch {

    private List<File> listFileFromDirectory;
    private String pathToDirectory;


    public AddListFilesToSearch() {

        listFileFromDirectory = new ArrayList<File>();

    }


    //добавим файлы в лист, в котором будем искать дупликаты из заданной директории и
    //поддиректориях
    public List<File> addFileFromDirectory() {
        File file = new File(pathToDirectory);
        //создаем массив файлов из директории
        File[] files = file.listFiles();
        for (File item : files) {
            //если item файл, но не директория, добавляем в поисковый список
            if (item.isFile()) {
                listFileFromDirectory.add(item);
            } else {
                pathToDirectory = item.getPath();
                addFileFromDirectory();

            }
        }
        return listFileFromDirectory;
    }




    public void setPathToDirectory(String pathToDirectory) {
        //TODO реализовать корректность ввода пути
        this.pathToDirectory = pathToDirectory;
    }


}
