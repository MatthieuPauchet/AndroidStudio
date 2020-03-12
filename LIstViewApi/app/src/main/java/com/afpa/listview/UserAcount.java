package com.afpa.listview;

import android.widget.ImageView;
import android.widget.TextView;

public class UserAcount {
    private String userName;
    private String userType;
    private Boolean active;

    public String toString(){
        return this.userName+"("+this.userType+")";
    }

    public UserAcount(String userName, String userType, Boolean active) {
        this.userName = userName;
        this.userType = userType;
        this.active = active;
    }

    public UserAcount(String userName, String userType) {
        this.userName = userName;
        this.userType = userType;
        this.active = true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



}
