package json.get;

import json.BaseJson;

public class CourseJson extends BaseJson {
    private String schoolname;
    private String subject;
    private int courseNum;
    private String profFirstName;
    private String profLastName;

    public void setSchoolname (String schoolname) { this.schoolname = schoolname; }
    public void setSubject (String subject) {this.subject = subject;}
    public void setCourseNum (int courseNum) {this.courseNum = courseNum;}
    public void setProfFirstName (String profFirstName) {this.profFirstName = profFirstName;}
    public void setProfLastName (String profLastName) {this.profLastName = profLastName;}

}
