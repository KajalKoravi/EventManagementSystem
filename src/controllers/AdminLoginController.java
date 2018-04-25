/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import models.AdminRegModel;
import models.ParticipantModel;
import utility.Utilities;

/**
 * FXML Controller class
 *
 * @author Kajo
 */
public class AdminLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */

    //creates object of DBoperation class
    DBOperation dbOperation = new DBOperation();

    // creates objectv of Utilities class
    Utilities u = new Utilities();


    @FXML
    private TextField admin_username;

    @FXML
    private PasswordField admin_password;

    @FXML
    void adminLogin(ActionEvent event) {
      // performs login activity for admin
      // checks if admin exist or not by verifying username and password provided by user at the time of registration
        if (dbOperation.checkIfAdminExists(admin_username.getText(),admin_password.getText())){
//            u.showAlert("success","login success");

           // stores all data accessed from admin registration by 'getAdminByUser' function in object of Admin Model
            AdminRegModel am = dbOperation.getAdminByUsername(admin_username.getText());

            // data srored in Admin Model use as a temporary storage static variables inside  Utilities class for further surfing or access
              Utilities.head_id = am.getId();
              Utilities.head_email = am.getMail();
              Utilities.head_name = am.getName();

            // after successful Login this function navigates admin to admin panel i.e it loads admin panel window
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


        }else{

            // shows alert of login failed if admin doesn't exist
            // or data accessed from particular registration doesn't match username , password credentials entered in admin login place
            u.showAlert("fail","login failed");
        }


    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
