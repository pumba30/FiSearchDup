import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 01.12.2014.
 */
public class DuplicateFind {

    private List<File> listOriginalFilesFromOurDirectory;
    private List<File> listOfFoundFilesDupl;

    //храним в Map - файл  как ключ, значение - список ArrayList<File> найденных файлов, которые
    //соответствуют файлу ключу
    private HashMap<File, ArrayList<File>> foundDuplicates;


    public DuplicateFind() {
        this.listOriginalFilesFromOurDirectory = new ArrayList<File>();
        this.listOfFoundFilesDupl = new ArrayList<File>();
        this.foundDuplicates = new HashMap<File, ArrayList<File>>();
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
                String originalFileName = matcher.group(1) + matcher.group(3);
                //File originalFile = new File(item, originalFileName);

                    listOriginalFilesFromOurDirectory.add(item);
            }
        }
        return listOriginalFilesFromOurDirectory;
    }

    public void outOnScreenDuplicatesFiles(List<File> listOriginalFilesFromOurDirectory ) {
        System.out.println("\nНайденные копии файлов:\n");
        for(File item : listOriginalFilesFromOurDirectory){
            System.out.println(item + "\n");
        }

    }

}
