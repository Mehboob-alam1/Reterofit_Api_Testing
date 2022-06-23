package com.advisecubeconsulting.apitesting;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("userId")
    private int  userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
