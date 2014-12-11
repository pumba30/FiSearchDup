import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pumba30 on 27.11.2014.
 * Программа для поиска дупликатов файлов в
 * заданной директории и поддиректориях.
 * Список найденных файлов можно сохранить в файл.
 * Также найденные файлы можно удалить с диска.
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {


        FileListAdd fileListAdd = new FileListAdd();
        System.out.println("Поиск файлов: ");
        System.out.println("Введите \"1\" - дупликаты\nВведите \"2\" - совпадение имени");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufferedReader.readLine();

        if (inputLine.equals("1")) {
            //метод для поиска дупликатов
            fileListAdd.getDuplicateFile();

        } else if (inputLine.equals("2")) {
            //метод для поиска по совпадении имени
            fileListAdd.getDuplicateFileByName();//todo реализовать
        } else return;


        System.out.println("\nХотите сохранить список найденных дупликатов в файл?  y/n\n");
        inputLine = bufferedReader.readLine();
        if (inputLine.equalsIgnoreCase("y")) {
            //вызываем метод для сохранения
            SaveToFile saveToFile = new SaveToFile(fileListAdd.getDuplFiles());
            saveToFile.saveToFile();
            String dir = saveToFile.getPathToSave();

            System.out.println("Сохранили список  в директорию " + dir);

        } else {
            //выходим из метода
            return;
        }



//        System.out.println("\nХотите удалить данные файлы из директории? y/n\n");
//        //вызываем метод для удаления найденных файлов
//        fileListAdd.deleteDuplFiles();
    }

}