/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.FeedbackModel;

/**
 * FXML Controller class
 *
 * @author Kajo
 */
public class ShowFeedbackController implements Initializable {


    @FXML
    public Label name0;

    @FXML
    public Label event_att0;

    @FXML
    public Label fb0;

    @FXML
    public Label name1;

    @FXML
    public Label event_att1;

    @FXML
    public Label fb1;

    @FXML
    public Label name2;

    @FXML
    public Label event_att2;

    @FXML
    public Label fb2;

    @FXML
    public Label name3;

    @FXML
    public Label event_att3;

    @FXML
    public Label fb3;

    int page_number=0;
    int offset =4;
    DBOperation operation= new DBOperation();

    @FXML
    void addFeedback(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Feedback.fxml"));
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
    void showNextPage(ActionEvent event) {

        page_number+=offset;
        setFeedbackData(page_number);

    }

    @FXML
    void showPreviousPage(ActionEvent event) {

        page_number-=offset;
        setFeedbackData(page_number);


    }


    void setFeedbackData(int page_number)
    {
        ArrayList<FeedbackModel> feedbackModelArrayList =operation.getAllFeedbacks(page_number);

        FeedbackModel feedbackModel0=feedbackModelArrayList.get(0);
        FeedbackModel feedbackModel1=feedbackModelArrayList.get(1);
        FeedbackModel feedbackModel2=feedbackModelArrayList.get(2);
        FeedbackModel feedbackModel3=feedbackModelArrayList.get(3);

        name0.setText(feedbackModel0.getName());
        event_att0.setText(feedbackModel0.getEvent_attended());
        fb0.setText(feedbackModel0.getComment());

        name1.setText(feedbackModel1.getName());
        event_att1.setText(feedbackModel1.getEvent_attended());
        fb1.setText(feedbackModel1.getComment());

        name2.setText(feedbackModel2.getName());
        event_att2.setText(feedbackModel2.getEvent_attended());
        fb2.setText(feedbackModel2.getComment());

        name3.setText(feedbackModel3.getName());
        event_att3.setText(feedbackModel3.getEvent_attended());
        fb3.setText(feedbackModel3.getComment());

        System.out.println(feedbackModelArrayList.toArray().toString());

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

             setFeedbackData(page_number);


    }


}
