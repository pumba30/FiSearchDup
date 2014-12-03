import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pumba30 on 03.12.2014.
 */
public class InputUserData {
    private String inputLine;


    public void getUserInput() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputLine = bufferedReader.readLine();
            if (inputLine.length() == 0) {
                getUserInput();
            }
        } catch (IOException e) {
            System.err.println("IOException " + e);
        }

    }

    public String getInputLine() {

        return inputLine;
    }

}
