import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 01.12.2014.
 */
public class DuplicateFind {

    private List<File> listFilesFromOurDirectory;
    private List<File> listOfFoundFilesDupl;

    //храним в Map - файл  как ключ, значение - список ArrayList<File> найденных файлов, которые
    //соответствуют файлу ключу
    private HashMap<File, ArrayList<File>> duplicates;


    public DuplicateFind(List<File> listFilesFromOurDirector) {
        this.listFilesFromOurDirectory = listFilesFromOurDirectory;
        this.listOfFoundFilesDupl = new ArrayList<File>();
        this.duplicates = new HashMap<File, ArrayList<File>>();
    }

    //находим возможные дубликаты по шаблону (по совпадению имени,
    // по совпадению имени с номером в скобках)
    public void toFindPossibleDuplicates(List<File> listFilesFromOurDirectory) {

        //бежим по листу и сравниваем с шаблоном
        for (File item : listFilesFromOurDirectory) {
            //используем для задания шаблона регулярные выражения
            Pattern pattern = Pattern.compile("^(.+)(\\s\\(\\d+\\))(.*)");
            Matcher matcher = pattern.matcher(item.getName());

        }

    }


}
