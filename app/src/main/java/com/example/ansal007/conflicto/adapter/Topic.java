package com.example.ansal007.conflicto.adapter;

/**
 * Created by Ansal007 on 7/4/16.
 */
public class Topic {

    private String userDisplayName;
    private String title;
    private String description;
    private int likers;
    private int dislikers;
    private int followers;
    private int favourers;
    private int conflicters;
    private String postedOn;

    public Topic(String userDisplayName, String title, String description, int likers, int dislikers, int followers, int favourers, int conflicters, String postedOn) {
        this.userDisplayName = userDisplayName;
        this.title = title;
        this.description = description;
        this.likers = likers;
        this.dislikers = dislikers;
        this.followers = followers;
        this.favourers = favourers;
        this.conflicters = conflicters;
        this.postedOn = postedOn;
    }

    public Topic(){}

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikers() {
        return likers;
    }

    public void setLikers(int likers) {
        this.likers = likers;
    }

    public int getDislikers() {
        return dislikers;
    }

    public void setDislikers(int dislikers) {
        this.dislikers = dislikers;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFavourers() {
        return favourers;
    }

    public void setFavourers(int favourers) {
        this.favourers = favourers;
    }

    public int getConflicters() {
        return conflicters;
    }

    public void setConflicters(int conflicters) {
        this.conflicters = conflicters;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }
}
