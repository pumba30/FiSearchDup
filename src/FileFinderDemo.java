import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pumba30 on 27.11.2014.
 */
public class FileFinderDemo {


    public static void main(String[] args) throws IOException {

        String dirPath = ""; // имя каталога в которой будем проверять наличие файлов-дубликатов

        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Input path directory: ");
        try {
            dirPath = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File(dirPath);

        if (dir.isDirectory()) { // является ли dir директорией
            System.out.println("Directory of " + dirPath);
            String list[] = dir.list(); // создаем массив, который выведет в список имена файлов

            for (int i = 0; i < list.length; i++) {
                File f = new File(dirPath + "/" + list[i]);
                if (f.isDirectory()) { // является ли f директорией
                    System.out.println("- " + list[i] + " -" + " is a directory");
                } else {
                    System.out.println(list[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirPath + " is not a directory");
        }
    }


}


