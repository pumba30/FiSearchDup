import java.io.File;
import java.util.List;

/**
 * Created by pumba30 on 27.11.2014.
 */
public class FileFinderDemo {


    public static void main(String[] args) {
        System.out.println("Введите путь к директории: ");
        InputUserData userData = new InputUserData();
        userData.getUserInput();
        String pathDirectory = userData.getInputLine();

        FileListAdd listAdd = new FileListAdd(pathDirectory);

        //получаем список файлов в директории и поддиректориях
        List<File> list = listAdd.getFileList();






//        test output to screen
//        List<File> list = listAdd.getFileList();
//        for(File item : list){
//            System.out.println(item.getName());
//        }


    }
}