import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by pumba30 on 27.11.2014.
 * Программа для поиска дупликатов файлов в
 * заданной директории и поддиректориях.
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {

        FileListAdd fileListAdd = new FileListAdd();

        System.out.println("Поиск файлов: ");
        System.out.println("Введите \"1\" - дупликаты\nВведите \"2\" - совпадение имени");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufferedReader.readLine();
        if (inputLine == "1") {
            //метод для поиска дупликатов
        } else if (inputLine == "2") {
            //метод для поиска по совпадении имени
        } else return;

        System.out.println("Введите путь к директории: ");
        inputLine = bufferedReader.readLine();
        fileListAdd.setPathToDirectory(inputLine);

        //TODO провести проверку на корректность ввода в методе setPathToDirectory()
        String path = fileListAdd.getPathToDirectoty();
        //получаем список файлов
        List<File> fileList = fileListAdd.getListFiles(path);
        //выведем на экран список ИМЕН найденных файлов
        System.out.println("Список файлов в заданной директории :\n");
        for (File item : fileList) {
            String name = item.getName();
            System.out.println(name);
        }
        System.out.println("Хотите сохранить список в файл?  y/n\n");
        inputLine = bufferedReader.readLine();
        if (inputLine.equalsIgnoreCase("y")) {
            //вызываем метод для сохранения
            SaveToFile saveToFile = new SaveToFile(fileList);
            saveToFile.saveToFile();
            System.out.println("Сохранили список!");
        } else {
            //выходим из метода
            return;
        }

        DuplicateFind duplicateFind = new DuplicateFind();
        List<File> duplFiles = duplicateFind.toFindPossibleDuplicates(fileList);
        duplicateFind.outOnScreenDuplicatesFiles(duplFiles);

        System.out.println("Хотите удалить данные файлы из директории? y/n\n");
        //вызываем метод для удаления найденных файлов


    }

}