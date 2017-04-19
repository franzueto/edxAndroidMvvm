package edu.galileo.mvvm;

import android.util.Log;
import android.view.View;

public class ContactViewModel {

    private ContactModel contactModel;

    public ContactViewModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public String getName() {
        return contactModel.name;
    }

    public String getPhone() {
        return contactModel.phoneNumber;
    }

    public boolean getEnabled() {
        return contactModel.enabled;
    }

    public void onCallClick(View v) {
        Log.d("Calling", contactModel.name);
        Log.d("To Number", contactModel.phoneNumber);
    }
}
