
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.AdminRegModel;


public class HeadRegistrationController implements Initializable {

    
    @FXML
    private TextField name;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField password;
    
    @FXML
    private Button submit;


    @FXML
    void doSubmit(ActionEvent event) {

        // after registration button clicked takes value user entered and set to the object of admin model

        AdminRegModel am= new AdminRegModel();
        am.setName(name.getText());
        am.setMail(mail.getText());
        am.setPasswodr(password.getText());

        // creates object of DBOperation class  'po' and
        // using 'po' object passes filled object 'pm' of a  participants model to the 'insertParticipant' method

        DBOperation ao=new DBOperation();
        ao.insertHead(am);

        // clears all data from fields after clicking submit button

        name.clear();
        mail.clear();
        password.clear();


        // navigates admin after successful registration to the admin panel page
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AdminPanel.fxml"));
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


                }
}
 