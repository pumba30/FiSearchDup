import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 01.12.2014.
 */
public class DuplicateFind  {

    private List<File> listDuplicatesFiles;
    private List<File> fileListDupl;


    public DuplicateFind() {
        this.listDuplicatesFiles = new ArrayList<File>();



    }

    //находим возможные дубликаты по шаблону pattern -
    //file.txt  - оригинал
    //file (1).txt -  дубликат, file - копия (1).txt - дубликат
    public List<File> toFindPossibleDuplicates(List<File> listFilesFromOurDirectory) {


        //используем для задания шаблона регулярные выражения
        Pattern pattern = Pattern.compile("^(.+)((\\s-\\sкопия)|(\\s\\(\\d+\\)))(.*)$");

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

    //находим файлы-дубликаты по совпадении имени, расширение файла - любое
    //@return коллекция Map состоящая из ключа(имя файла) и значения(список файлов с одинаковым именем
    //не учитывая расширения)
    public Map<String, List<File>> toFindByName(List<File> listFilesFromOurDirectory) {
        Map<String, List<File>> result = new HashMap<String, List<File>>();
        for (int i = 0; i < listFilesFromOurDirectory.size(); i++) {

            //имя файла без разширения файла
            String name = listFilesFromOurDirectory.get(i).getName().substring(0,
                    listFilesFromOurDirectory.get(i).getName().length() - 4);
            //элемент (файл) листа файлов
            File item = listFilesFromOurDirectory.get(i);

            if (!result.containsKey(name)) {
                result.put(name, new ArrayList<File>());
            }

            for (int j = 0; j < listFilesFromOurDirectory.size(); j++) {
                String name2 = listFilesFromOurDirectory.get(j).getName().substring(0,
                        listFilesFromOurDirectory.get(j).getName().length() - 4);
                if (name2.equals(name)) {
                    result.get(name).add(item);
                    break;
                }
            }
        }
        return result;
    }

    //выводим список найденных файлов на экран
    public void outOnScreenDuplFilesByName(Map<String, List<File>> result) throws IOException {
        System.out.println("\nНайденные копии файлов по имени:");
        FileListAdd listAdd = new FileListAdd();
        fileListDupl = listAdd.getDuplFiles();

        for (Map.Entry<String, List<File>> entry : result.entrySet()) {
            System.out.println("Список для " + entry.getKey() + ":");
            List<File> fileList = entry.getValue();

            for (File item : fileList) {
                System.out.println(item);
                fileListDupl.add(item);
            }
            System.out.println("");
        }

        listAdd.setDuplFiles(fileListDupl);

    }

    //выводим список найденных файлов на экран
    public void outOnScreenDuplicatesFiles(List<File> listFilesFromOurDirectory) {
        System.out.println("\nНайденные копии файлов:");
        for (File item : listFilesFromOurDirectory) {
            System.out.println(item);
        }

    }


}
