
package models;


public class EventModel {
    
    private Integer event_head;
    private String event_name;
    private String event_type;
    private String venue;
    private String time;

    private int id;
    private String head;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead_username() {
        return head_username;
    }

    public void setHead_username(String head_username) {
        this.head_username = head_username;
    }

    public String getHead_email() {
        return head_email;
    }

    public void setHead_email(String head_email) {
        this.head_email = head_email;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    private String event_date;
    private String fees;
    private String sponcered_by;
    private String Contact;
    private String info;


    private String head_username;
    private String head_email;


    public Integer getEvent_head() {
        return event_head;
    }

    public void setEvent_head(Integer event_head) {
        this.event_head = event_head;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getSponcered_by() {
        return sponcered_by;
    }

    public void setSponcered_by(String sponcered_by) {
        this.sponcered_by = sponcered_by;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
