package com.WirelessDynamics.ToDoApp;

public class MyDutyModel {
    private String dutyTitle, dutyDate, dutyDesc;

    public MyDutyModel() {

    }

    public MyDutyModel(String dutyTitle, String dutyDate, String dutyDesc) {
        this.dutyTitle = dutyTitle;
        this.dutyDate = dutyDate;
        this.dutyDesc = dutyDesc;
    }


    public String getDutyTitle() {
        return dutyTitle;
    }

    public void setDutyTitle(String dutyTitle) {
        this.dutyTitle = dutyTitle;
    }

    public String getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(String dutyDate) {
        this.dutyDate = dutyDate;
    }

    public String getDutyDesc() {
        return dutyDesc;
    }

    public void setDutyDesc(String dutyDesc) {
        this.dutyDesc = dutyDesc;
    }
}
