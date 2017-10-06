package com.actionmedia.components;

public class PersonInfo {

    String login;
    String email;
    String LastName;
    String FirsName;
    String secondName;
    String access;

    public PersonInfo(){

    }

    public PersonInfo(String login, String email, String LastName, String firsName, String secondName, String access) {
        this.login = login;
        this.email = email;
        this.LastName = LastName;
        this.FirsName = firsName;
        this.secondName = secondName;
        this.access = access;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLastName() {
        return this.LastName;
    }

    public String getFirsName() {
        return this.FirsName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getAccess() { return  this.access;}
}
