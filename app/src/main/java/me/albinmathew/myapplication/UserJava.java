package me.albinmathew.myapplication;

import android.support.annotation.Nullable;

public class UserJava {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(@Nullable final Object obj) {
        if (obj instanceof UserJava) {
            return ((UserJava) obj).firstName.equals(this.firstName) && ((UserJava) obj).lastName.equals(this.firstName);
        } else {
            return false;
        }
    }
}
