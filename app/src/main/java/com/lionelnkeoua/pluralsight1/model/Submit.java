package com.lionelnkeoua.pluralsight1.model;

public class Submit {

    private String firstname;
    private String lastname;
    private String email;
    private String githubLink;

    public Submit(String firstname, String lastname, String email, String githubLink) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.githubLink = githubLink;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}
