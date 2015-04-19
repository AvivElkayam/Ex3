package com.example.mac.ex3;

/**
 * Created by mac on 4/16/15.
 */
public class Student {
    private String name;
    private String id;
    private String address;
    private String phone;
    private boolean checked;

    public Student(String name, String id, String address, String phone, boolean checked) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
