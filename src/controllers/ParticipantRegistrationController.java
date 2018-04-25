
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import models.ParticipantModel;
//import DBOperation.DBOperation;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.ParticipantModel;


public class ParticipantRegistrationController implements Initializable {

    @FXML
    private TextField participant_name;

    @FXML
    private TextField email_id;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnSubmit;


    @FXML
    void myBtnClicked(ActionEvent event) {
        System.out.println("hello");
       // after registration button clicked takes value user entered and set to the object of participant model
        ParticipantModel pm = new ParticipantModel();
        pm.setName(participant_name.getText());
        pm.setEmail(email_id.getText());
        pm.setPassword(password.getText());

        // creates object of DBOperation class  'po' and
        // using 'po' object passes filled object 'pm' of a  participants model to the 'insertParticipant' method
        DBOperation po = new DBOperation();
        po.insertParticipant(pm);

        // clears all data from fields after clicking submit button
        participant_name.clear();
        email_id.clear();
        password.clear();

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ParticipantLogins.fxml"));
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }








    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        System.out.println("init");


    }
}
