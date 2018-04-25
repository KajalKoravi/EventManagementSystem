
package models;


public class FeedbackModel {

    private String name;
    private String mail;
    private String mobile;
    private String event_attended;
    private String comment;
    
    public String getEvent_attended() {
        return event_attended;
    }

    public void setEvent_attended(String event_attended) {
        this.event_attended = event_attended;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    }
