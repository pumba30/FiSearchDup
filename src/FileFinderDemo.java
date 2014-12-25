import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pumba30 on 27.11.2014.
 * Программа для поиска дупликатов файлов в
 * заданной директории и поддиректориях.
 * Список найденных файлов можно сохранить в файл.
 * Также найденные файлы можно удалить с диска.
 *
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {

        AddListFilesToSearch filesToSearch = new AddListFilesToSearch();

        System.out.println("Введите путь к директории: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufferedReader.readLine();

        //проверка  добавления файлов в список и вывод на экран
        filesToSearch.setPathToDirectory(inputLine);
        List<File> fileListOfDirectory = filesToSearch.addFileFromDirectory();
        listToScreen(fileListOfDirectory);

        FindByCopy byCopy = new FindByCopy(fileListOfDirectory);
        HashMap<File, List<File>> resList = byCopy.findOriginDulplFiles(fileListOfDirectory);
        List<File> listByPatternName = byCopy.findPossibleDuplicates(fileListOfDirectory);
        listToScreen(listByPatternName);









    }

    //просмотр  и вывод на экран файлов, взятых из директории
    public static void listToScreen(List<File> fileList) {
        if (fileList != null)
            for (File item : fileList) {
                System.out.println(item );
            }
        System.out.println();
    }

    //вывод на экран множества списков дупликатов
    public static void listOriginOnScreen(HashMap<File, List<File>> resultList){
        for(Map.Entry<File, List<File>> item : resultList.entrySet()){
            System.out.print(item.getKey() + "==\n" );
            List<File> list = item.getValue();
            listToScreen(list);

        }
    }

}