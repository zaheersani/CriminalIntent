package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    // UUID - Universal Unique ID
    private UUID mId;
    private String Title;
    private Date Date;
    private boolean Solved;

    public Crime() {
        // Generate Random Unique ID
        mId = UUID.randomUUID();
        Date = new Date();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public boolean isSolved() {
        return Solved;
    }

    public void setSolved(boolean solved) {
        Solved = solved;
    }
}
