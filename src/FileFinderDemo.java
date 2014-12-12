import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by pumba30 on 27.11.2014.
 * Программа для поиска дупликатов файлов в
 * заданной директории и поддиректориях.
 * Список найденных файлов можно сохранить в файл.
 * Также найденные файлы можно удалить с диска.
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {

        AddListFilesToSearch filesToSearch = new AddListFilesToSearch();

        System.out.println("Введите путь к директории: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufferedReader.readLine();

        //проверка  добавления файлов в список и вывод на экран
        filesToSearch.setPathToDirectory(inputLine);
        List<File> fileList = filesToSearch.addFileFromDirectory();
        listToScreen(fileList);



        FindByCopy byCopy = new FindByCopy(fileList);
        List<File> listByCopy = byCopy.findPossibleDuplicates();
        listToScreen(listByCopy);


//        System.out.println("\nХотите сохранить список найденных дупликатов в файл?  y/n\n");
//        inputLine = bufferedReader.readLine();
//        if (inputLine.equalsIgnoreCase("y")) {
//            //вызываем метод для сохранения
//            SaveToFile saveToFile = new SaveToFile(fileListAdd.getDuplFiles());
//            saveToFile.saveToFile();
//            String dir = saveToFile.getPathToSave();
//
//            System.out.println("Сохранили список  в директорию " + dir);
//
//        } else {
//            //выходим из метода
//            return;
//        }


//        System.out.println("\nХотите удалить данные файлы из директории? y/n\n");
//        //вызываем метод для удаления найденных файлов
//        fileListAdd.deleteDuplFiles();
    }

    //просмотр  и вывод на экран файлов, взятых из директории
    public static void listToScreen(List<File> fileList) {
        if (fileList != null)
            for (File item : fileList) {
                System.out.println(item);
            }
        System.out.println();

    }

}