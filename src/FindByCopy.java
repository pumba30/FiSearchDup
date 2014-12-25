import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 12.12.2014.
 */
public class FindByCopy extends SearchDuplicatesFiles {
    //шаблон, по которому ищем копию
    private Pattern pattern = Pattern.compile("^(.+)((\\s-\\sкопия)|(\\s\\(\\d+\\)))(.*)$");
    private String originalFileName;
    private List<File> foundFiles;
    /**
     * @param File ключ - оригиналный файл
     * @param List<File> значение - список, который содержит оригинальный файл?
     */
    private HashMap<File, List<File>> resultList;


    public FindByCopy(List<File> fileList) {
        super(fileList);
        foundFiles = new ArrayList<File>();
    }


    //находим возможные дубликаты по шаблону pattern -
    //file.txt  - оригинал
    //file (1).txt -  дубликат, file - копия (1).txt - дубликат
    @Override
    public List<File> findPossibleDuplicates(List<File> list) {
        //бежим по листу и сравниваем с шаблоном
        for (File item : list) {
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

    //метод возвращает множество списков с оригинальным файлом
    public HashMap<File, List<File>> findOriginDulplFiles(List<File> foundFiles) {
        HashMap<File, List<File>> resultList = new HashMap<File, List<File>>();
        for (int i = 0; i < foundFiles.size(); i++) {
            if (!resultList.containsKey(foundFiles.get(i))) {
                resultList.put(foundFiles.get(i), new ArrayList<File>());
                resultList.get(foundFiles.get(i)).add(foundFiles.get(i));
            }
        }
        return resultList;
    }


}
