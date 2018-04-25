
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.ParticipantModel;
import utility.Utilities;


public class ParticipantLoginController implements Initializable {

    // creates object of DBOperation and Utilities class
    DBOperation dbOperation = new DBOperation();
    Utilities u = new Utilities();

    @FXML
    private TextField username;

    @FXML
    private PasswordField paricipant_password;

    @FXML
    void registrationEvent(MouseEvent event) {
        //  loads new window of user registration if user doesn't have any account
        // and  user clicked on create new account

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ParticipantRegistration.fxml"));
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

    @FXML
    void ParticipantLogin(ActionEvent event) {
        // varibles stores username and password  accessed from user registration event
        String enteredUsername = username.getText();
        String enteredPassword = paricipant_password.getText();

        // checks if user exist or not by verifying username and password provided by user at the time of registration
        if (dbOperation.checkIfUserExists(enteredUsername,enteredPassword) )
        {
//            u.showAlert("success","login success");

            //  get all data accessed from user registration by 'getParticipantByUsername' function in an empty object of user Model


            ParticipantModel pm = dbOperation.getParticipantByUsername(username.getText());

            // data stored in Admin Model use as a temporary storage static variables
            // inside  Utilities class for further surfing or access

            Utilities.participant_id = pm.getId();
            Utilities.participant_email = pm.getEmail();
            Utilities.participant_name = pm.getName();

            // navigates user to the home page after successful login
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Home.fxml"));
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


        }else{

            // gives alert message as a login failed if user doesn't exist
            u.showAlert("fail","login failed");
        }


    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
