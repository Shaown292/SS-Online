package com.syssolution.ssonline;

public class user_helper {
    String name, user_name, mail, phone_no;


    public user_helper(String name, String user_name, String mail, String phone_no) {
        this.name = name;
        this.user_name = user_name;
        this.mail = mail;
        this.phone_no = phone_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
