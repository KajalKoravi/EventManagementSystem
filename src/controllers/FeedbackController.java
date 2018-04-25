/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.FeedbackModel;

/**
 * FXML Controller class
 *
 * @author Kajo
 */
public class FeedbackController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField name;

    @FXML
    private TextField mail;

    @FXML
    private TextField mobile;

    @FXML
    private TextField event_attended;

    @FXML
    private TextArea feedback;

    @FXML
    void submitFeedback(ActionEvent event) {
        FeedbackModel fm=new FeedbackModel();

        fm.setName(name.getText());
        fm.setMail(mail.getText());
        fm.setMobile(mobile.getText());
        fm.setEvent_attended(event_attended.getText());
        fm.setComment(feedback.getText());

        DBOperation da=new DBOperation();
        da.insertFeedback(fm);

        name.clear();
        mail.clear();
        mobile.clear();
        event_attended.clear();
        feedback.clear();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
