/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.EventModel;
import utility.Utilities;

/**
 * FXML Controller class
 *
 * @author Kajo
 */
public class ViewEventController implements Initializable {

    @FXML
    public TextField title1;
    @FXML
    public TextArea info1;
    @FXML
    public TextField venue1;
    @FXML
    public TextField time1;
    @FXML
    public TextField date1;


    @FXML
    public TextField title0;
    @FXML
    public TextArea info0;
    @FXML
    public TextField venue0;
    @FXML
    public TextField time0;
    @FXML
    public TextField date0;


    public String event_name;
    public Button update0;
    public Button update1;


    int page_number = 0 ;
    int offset =  2;

    DBOperation db = new DBOperation();

    EventModel eventModel0;
    EventModel eventModel1;

    Utilities u = new Utilities();
    /**
     * Initializes the controller class.
     */

    public void openEvent(String event_name){
//        this.event_name = event_name;

        setEventData(page_number, event_name);

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO



        if(Utilities.head_id != 0 ){
            update0.setVisible(true);
            update1.setVisible(true);

        }



    }



    public void btnBackClicked(ActionEvent actionEvent) {
        page_number = page_number-offset;

        if(page_number < 0 || page_number == 0 ){
            new Utilities().showAlert("","You are on first page");
        }else{
            setEventData(page_number, event_name);

        }

    }

    public void btnNextClicked(ActionEvent actionEvent) {
        page_number = page_number+offset;

        setEventData(page_number, event_name);

    }


    void setEventData(int page_number, String event_name){

        ArrayList<EventModel> arr = db.getAllEvents(page_number, event_name);

        eventModel0 = arr.get(0);
        eventModel1 = arr.get(1);

        title0.setText(eventModel0.getEvent_name());
        info0.setText(eventModel0.getInfo());
        venue0.setText(eventModel0.getVenue());
        time0.setText(eventModel0.getTime());
        date0.setText(eventModel0.getEvent_date().toString());

        title1.setText(eventModel1.getEvent_name());
        info1.setText(eventModel1.getInfo());
        venue1.setText(eventModel1.getVenue());
        time1.setText(eventModel1.getTime());
        date1.setText(String.valueOf(eventModel1.getEvent_date()));



        System.out.println(arr.toArray().toString());
    }


    public void reg0Clicked(ActionEvent actionEvent) {

        int event_id = eventModel0.getId();
        int participant_id = Utilities.participant_id;

        if(participant_id == 0){
            u.showAlert("fail","Please login to continue",Alert.AlertType.ERROR);

            return ;
        }

        if(db.checkIfAlreadyBookedForEvent(event_id,participant_id)){
            u.showAlert("fail","you are already done booking for this event",Alert.AlertType.ERROR);
        }else{
            db.doEventBooking(event_id,participant_id );
        }




    }

    public void reg1Clicked(ActionEvent actionEvent) {

        int event_id = eventModel1.getId();
        int participant_id = Utilities.participant_id;

        if(participant_id == 0){
            u.showAlert("fail","Please login to continue",Alert.AlertType.ERROR);

            return ;
        }

        if(db.checkIfAlreadyBookedForEvent(event_id,participant_id)){
            u.showAlert("fail","you are already done booking for this event", Alert.AlertType.ERROR);
        }else{
            db.doEventBooking(event_id,participant_id );
        }
    }

    public void update0Clicked(ActionEvent actionEvent) {

        //get all info from all textfields 0 and fire update query

        EventModel em = new EventModel();

        em.setEvent_name(title0.getText());
        // initialise remaining data

        db.updateEvent(em);
    }

    public void update1Clicked(ActionEvent actionEvent) {

    }
}
