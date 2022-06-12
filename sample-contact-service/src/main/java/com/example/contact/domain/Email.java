package com.example.contact.domain;

public class Email {
    private String email;
    private String emailType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", emailType='" + emailType + '\'' +
                '}';
    }
}
