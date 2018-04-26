package DBOperation;

import db.DB_conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.AdminRegModel;
import models.EventModel;
import models.FeedbackModel;
import models.ParticipantModel;
import utility.Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kajo
 */
public class DBOperation {

    DB_conn db = new DB_conn();
    Utilities u = new Utilities();

    public void insertParticipant(ParticipantModel pm) {

        // database operation function writes query to insert all the data set into participant model


        try {
            Statement stmt = db.connect().createStatement();
            String qry = "INSERT INTO `participant`( `username`, `email`, `password`)"
                    + " VALUES ('" + pm.getName() + "','" + pm.getEmail() + "','" + pm.getPassword() + "')";

            System.out.println(qry);
            stmt.executeUpdate(qry);


            u.showAlert("Success", "Participant added");


        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void insertHead(AdminRegModel am) {
        try {
            Statement stmt = db.connect().createStatement();
            String qry = "INSERT INTO admin(username,email,pwd)" + "VALUES('" + am.getName() + "','" + am.getMail() + "','" + am.getPassword() + "')";

            System.out.println(qry);
            stmt.executeUpdate(qry);

            u.showAlert("Success", "Head Added");

        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertEvent(EventModel em) {

        try {
            Statement stmt = db.connect().createStatement();
            String qry = "INSERT INTO `event`" +
                    "( `admin_id`, `name`, `event_type`, `venue`, `time`, `event_date`, `fees`, `sponcered_by`, `contact`, `info`) " +
                    "VALUES (" +
                    "'" + em.getEvent_head() + "'," +
                    "'" + em.getEvent_name() + "'," +
                    "'" + em.getEvent_type() + "'," +
                    "'" + em.getVenue() + "'," +
                    "'" + em.getTime() + "'," +
                    "'" + em.getEvent_date() + "'," +
                    "'" + em.getFees() + "'," +
                    "'" + em.getSponcered_by() + "'," +
                    "'" + em.getContact() + "'," +
                    "'" + em.getInfo() + "'" +
                    ")";

            System.out.println(qry);
            stmt.executeUpdate(qry);

            u.showAlert("Success", "Event Added");

        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }



    public void updateEvent(EventModel em) {

        try {
            Statement stmt = db.connect().createStatement();
            //update query here
            String qry = "";

            System.out.println(qry);
            stmt.executeUpdate(qry);

            u.showAlert("Success", "Event Updated");

        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }




    public void insertFeedback(FeedbackModel fm) {
        try {
            Statement stmt = db.connect().createStatement();
            String qry = "INSERT INTO feedback(name,mail,mobile,event_attended,feedback)" + "VALUES('" + fm.getName() + "','" + fm.getMail() + "','" + fm.getMobile() + "','" + fm.getEvent_attended() + "','" + fm.getComment()  + "')";

            System.out.println(qry);
            stmt.executeUpdate(qry);

            u.showAlert("Success", "Feedback Added");

        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



        public boolean checkIfUserExists(String username, String pwd) {

        // after clicking login button ,function checks username , password credentials present or not and returns boolean value

            try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM participant WHERE username = '" + username + "' AND password = '"+pwd+"' ";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);
            rs.last();

            int rowCount = rs.getRow(); // 1

//            int i = 0;
//            while (rs.next()){
//                i++;
//            }

            if(rowCount > 0){
                return true;
            }else{
                return false;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }



    public ParticipantModel getParticipantByUsername(String username) {
        // if 'checkIfUserExists' function returns true ,
        // then this function does access all the data from related user by its username
        ParticipantModel pm = new ParticipantModel();
        // creates empty object of an participant model
        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM participant WHERE username = '" + username + "'  ";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);
            //resultset executes one by one result from database and stores it into object of participant model created above

            while (rs.next()) {
                pm.setName(rs.getString("username"));
                pm.setId(rs.getInt("id"));
                pm.setEmail(rs.getString("email"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // returns object packed with all the related data of loged in user
        return pm;

    }

    public boolean checkIfAdminExists(String username, String pwd) {

        // after clicking login button ,function checks username , password credentials present or not and returns boolean value

        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM admin WHERE username = '" + username + "' AND pwd= '"+pwd+"' ";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);
            rs.last();

            int rowCount = rs.getRow();
            if(rowCount > 0){
                return true;
            }else{
                return false;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public AdminRegModel getAdminByUsername(String username) {

        // if 'checkIfAdminExists' function returns true then
        // this function accesses all data for the particular admin by its username

        AdminRegModel am = new AdminRegModel();
        // creates new object of admin model

        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM admin WHERE username = '" + username + "'  ";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);
            //resultset executes one by one data from database and stores it into empty object of an admin model created above

            while (rs.next()) {
                am.setName(rs.getString("username"));
                am.setId(rs.getInt("id"));
                am.setMail(rs.getString("email"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // returns object which is packed with all the registration data of  loged in admin
        return am;

    }




    public ArrayList<EventModel> getAllEvents(int page, String event_name) {

        ArrayList<EventModel> eventModelArrayList = new ArrayList<>();
        String qry;



        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();

            if(event_name.equals("upcoming")){
                 qry = "SELECT e.*, a.username as head FROM event e, admin a WHERE e.admin_id = a.id LIMIT "+page+",2";

            }else{
                qry = "SELECT e.*, a.username as head FROM event e, admin a WHERE e.admin_id = a.id AND e.event_type = '"+event_name+"' LIMIT "+page+",2";

            }
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);

            while (rs.next()) {
                EventModel em = new EventModel();

                em.setEvent_name(rs.getString("name"));
                em.setId(rs.getInt("id"));
                em.setEvent_type(rs.getString("event_type"));
                em.setHead(rs.getString("head"));
                em.setTime(rs.getString("time"));
                em.setVenue(rs.getString("venue"));
                em.setEvent_date(rs.getDate("event_date"));
                em.setFees(rs.getString("fees"));
                em.setSponcered_by(rs.getString("sponcered_by"));
                em.setContact(rs.getString("contact"));
                em.setInfo(rs.getString("info"));

                eventModelArrayList.add(em);

            }


        } catch (SQLException e) {

            u.showAlert("End","No events found");
            return null;
        }
        return eventModelArrayList;

    }

    public  ArrayList<FeedbackModel> getAllFeedbacks(int page)
    {
      ArrayList<FeedbackModel> feedbackModelArrayList=new ArrayList<>();


        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM feedback LIMIT "+page+",4";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);

            while (rs.next()) {
                FeedbackModel fm = new FeedbackModel();

                fm.setName(rs.getString("name"));
                fm.setMail(rs.getString("mail"));
                fm.setMobile(rs.getString("mobile"));
                fm.setEvent_attended(rs.getString("event_attended"));
                fm.setComment(rs.getString("feedback"));


                feedbackModelArrayList.add(fm);

            }


        } catch (SQLException e) {

            u.showAlert("End","No events found");
            return null;

        }
        return feedbackModelArrayList;

    }

    public void doEventBooking(int event_id, int participant_id){


        try {
            Statement stmt = db.connect().createStatement();
            String qry = "INSERT INTO `event_booking`( `event_id`, `participant_id`)"
                    + " VALUES ('" + event_id + "','" +participant_id + "')";

            System.out.println(qry);
            stmt.executeUpdate(qry);


            u.showAlert("Success", "You are successfully registered for this event");


        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public boolean checkIfAlreadyBookedForEvent(int event_id, int participant_id) {


        try {
            Statement stmt = null;
            stmt = db.connect().createStatement();
            String qry = "SELECT * FROM event_booking WHERE event_id = " + event_id + " AND participant_id= "+participant_id+" ";
            System.out.println(qry);

            ResultSet rs = stmt.executeQuery(qry);
            rs.last();

            int rowCount = rs.getRow();
            if(rowCount > 0){
                return true;
            }else{
                return false;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }



}







//    public EventModel getEvent() {
//
//        EventModel em = new EventModel();
//
//        try {
//            Statement stmt = null;
//            stmt = db.connect().createStatement();
//            String qry = "SELECT * FROM event WHERE id = " + 1 + "";
//            System.out.println(qry);
//
//            ResultSet rs = stmt.executeQuery(qry);
//
//            while (rs.next()) {
//                em.setEvent_name(rs.getString("name"));
//                em.setContact(rs.getInt("contact"));
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return em;
//
//    }




