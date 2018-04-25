package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

public class Utilities {


    public static int participant_id;
    public static  String participant_name;
    public static String participant_email;

    public static int head_id;
    public static  String head_name;
    public static  String head_email;


    public static void doLogout(){
        participant_name = null;
        participant_email = null;
        participant_id = 0;


        head_id = 0;
        head_name = null;
        head_email = null;

        //this function sets all data to blank.
    }


    public void showAlert(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void showAlert(String title, String content, Alert.AlertType type)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

}
