/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.EventModel;
import utility.Utilities;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.text.View;

/**
 *
 * @author Kajo
 */
public class HomeController implements Initializable {
    
 
    @FXML
    private Button fest;

    @FXML
    private Button btnLogout;

    @FXML
    private Label lable_login;
    Button button;

    @FXML
    void getConcerts(ActionEvent event) {

        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ViewEvents.fxml"));

            root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");

            ViewEventController controller = fxmlLoader.<ViewEventController>getController();

            controller.setEventName("Concerts");

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
    void getConference(ActionEvent event) {

    }

    @FXML
    void getContact(MouseEvent event) {

        // this method loads contact form/page in new window
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ContactUs.fxml"));
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void getExhibition(ActionEvent event) {

    }

    @FXML
    void getFeedBack(MouseEvent event) {

        // this method loads Feedback form in another window

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ShowFeedback.fxml"));
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void getFestival(ActionEvent event) {

    }

    @FXML
    void getHome(MouseEvent event) {

    }

    @FXML
    void getLogin(MouseEvent event) {

        //this function loads login form
        // but before opening login form, alert box function is used to choose either admin or user login

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Window");
        alert.setHeaderText("if you are a user or want to register for events Click on User Login or else click on Admin Login");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("User Login ");
        ButtonType buttonTypeTwo = new ButtonType("Admin Login");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
             // this function loads login form of user
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ParticipantsLogin.fxml"));
                Stage stage = new Stage();
                //stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 300, 500));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        } else if (result.get() == buttonTypeTwo) {
            // this function loads login form of admin

            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AdminLogin.fxml"));
                Stage stage = new Stage();
                //stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 300, 500));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }  else {
            // ... user chose CANCEL or closed the dialog
        }
        //alert.showAndWait();

    }

    @FXML
    void getOther(ActionEvent event) {

    }

    @FXML
    void getParties(ActionEvent event) {

    }

    @FXML
    void getTechEvents(ActionEvent event) {

    }

    @FXML
    void getWorkshop(ActionEvent event) {

    }


    @FXML
    void get_upcoming_events(MouseEvent event) {

        // this fumction loads form of all upcoming events

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ViewEvents.fxml"));
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
    void getseminars(ActionEvent event) {

    }

    @FXML
    void getstandup(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {




        // TODO
        // this condition sets loged participant's name at the place of login option as user will get confirmation of login activity
        if(Utilities.participant_name != null){
            lable_login.setText(Utilities.participant_name);

            btnLogout.setVisible(true);





        }


    }

    public void btnLogoutClicked(ActionEvent actionEvent) {

        //after clicking logout, just call logout method to clear data. and goto new home page

        Utilities.doLogout(); //now al data is cleared

        // refresh home page

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Home.fxml"));
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();




        }
        catch (IOException e) {
            e.printStackTrace();
        }




    }
}
