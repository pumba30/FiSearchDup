import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 01.12.2014.
 */
public class DuplicateFind {

    private List<File> listDuplicatesFiles;

    public DuplicateFind() {
        this.listDuplicatesFiles = new ArrayList<File>();
    }

    //находим возможные дубликаты по шаблону pattern  file.txt   - оригинал
    //file (1).txt -  дубликат
    public List<File> toFindPossibleDuplicates(List<File> listFilesFromOurDirectory) {

        //используем для задания шаблона регулярные выражения
        Pattern pattern = Pattern.compile("^(.+)(\\s\\(\\d+\\))(.*)$");

        //бежим по листу и сравниваем с шаблоном
        for (File item : listFilesFromOurDirectory) {
            String itemName = item.getName();
            Matcher matcher = pattern.matcher(itemName);
            if (matcher.find()) {
                listDuplicatesFiles.add(item);
            }
        }
        return listDuplicatesFiles;
    }

    //выводим список найденных файлов на экран
    public void outOnScreenDuplicatesFiles(List<File> listOriginalFilesFromOurDirectory) {
        System.out.println("\nНайденные копии файлов:\n");
        for (File item : listOriginalFilesFromOurDirectory) {
            System.out.println(item + "\n");
        }

    }

}
