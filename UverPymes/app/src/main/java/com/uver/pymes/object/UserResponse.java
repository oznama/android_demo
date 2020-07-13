package com.uver.pymes.object;

public class UserResponse {

    private int id;
    private String userFullName;
    private String userImg;
    private String position;
    private String positionTier;

    public UserResponse(int id, String userFullName, String userImg, String position, String positionTier) {
        this.id = id;
        this.userFullName = userFullName;
        this.userImg = userImg;
        this.position = position;
        this.positionTier = positionTier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionTier() {
        return positionTier;
    }

    public void setPositionTier(String positionTier) {
        this.positionTier = positionTier;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", userFullName='" + userFullName + '\'' +
                ", userImg='" + userImg + '\'' +
                ", position='" + position + '\'' +
                ", positionTier='" + positionTier + '\'' +
                '}';
    }
}
