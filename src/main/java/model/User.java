package model;

public class User { //only a copy of the supevisor database with getters and setters.
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String pwd;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String fn) {
        this.first_name = fn;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String ln) {
        this.last_name = ln;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
   
}
