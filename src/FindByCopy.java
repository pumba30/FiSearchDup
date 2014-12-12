import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 12.12.2014.
 */
public class FindByCopy extends SearchDuplicatesFiles {
    //шаблон, по которому ищем копию
    private Pattern pattern = Pattern.compile("^(.+)((\\s-\\sкопия)|(\\s\\(\\d+\\)))(.*)$");
    private List<File> foundFiles;


    public FindByCopy(List<File> fileList) {
        super(fileList);
        foundFiles = new ArrayList<File>();
    }


    //находим возможные дубликаты по шаблону pattern -
    //file.txt  - оригинал
    //file (1).txt -  дубликат, file - копия (1).txt - дубликат
    @Override
    public List<File> findPossibleDuplicates() {
        List<File> fileList = getFileList();

        //бежим по листу и сравниваем с шаблоном
        for (File item : fileList) {
            String itemName = item.getName();
            Matcher matcher = pattern.matcher(itemName);
            if (matcher.find()) {
                //добавляем найденный файл в список
                foundFiles = getReadyListFile();
                foundFiles.add(item);
            }
        }
        return foundFiles;
    }
}
