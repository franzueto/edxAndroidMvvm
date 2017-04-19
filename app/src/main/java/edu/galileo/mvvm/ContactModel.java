package edu.galileo.mvvm;

public class ContactModel {

    public String name;
    public boolean enabled;
    public String phoneNumber;

    public ContactModel(String name, boolean enabled, String phoneNumber) {
        this.name = name;
        this.enabled = enabled;
        this.phoneNumber = phoneNumber;
    }
}
