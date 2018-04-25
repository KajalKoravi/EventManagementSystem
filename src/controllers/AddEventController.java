
package controllers;

import DBOperation.DBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.EventModel;
import utility.Utilities;

import java.net.URL;
import java.util.ResourceBundle;


public class AddEventController implements Initializable {


    @FXML
    private TextField contact;

    @FXML
    private TextField event_name;

    @FXML
    private ComboBox<String> event_type;

    @FXML
    private TextField venue;

    @FXML
    private DatePicker event_date;

    @FXML
    private TextField fees;

    @FXML
    private TextField sponcer;

    @FXML
    private TextArea info;


    @FXML
    private TextField event_time;

    @FXML
    void addEvent(ActionEvent event) {
        EventModel em= new EventModel();



        if(Utilities.head_id != 0){
            em.setEvent_head(Utilities.head_id);
        }
        em.setEvent_name(event_name.getText());
        em.setEvent_type(event_type.getSelectionModel().getSelectedItem().toString());
        em.setVenue(venue.getText());
        em.setTime(event_time.getText());
        em.setEvent_date(event_date.getValue().toString());
        em.setFees(fees.getText());
        em.setSponcered_by(sponcer.getText());
        em.setContact(contact.getText());
        em.setInfo(info.getText());

        event_name.clear();
        event_type.getItems().clear();
        venue.clear();
        event_time.clear();
//        event_date.clear();
        fees.clear();
        sponcer.clear();
        contact.clear();
        info.clear();


        DBOperation ao=new DBOperation();
        ao.insertEvent(em);

    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


               event_type.getItems().addAll("","Concerts","Conference","Exhibition","Festival","Other","Parties","Tech-Events","Workshop","Seminars","Stand-Up Comedy");
                }


}
 