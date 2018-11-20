
package com.project.paginationdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("portfolio_url")
    @Expose
    private String portfolioUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("links")
    @Expose
    private Links_ links;
    @SerializedName("profile_image")
    @Expose
    private ProfileImage profileImage;
    @SerializedName("instagram_username")
    @Expose
    private String instagramUsername;
    @SerializedName("total_collections")
    @Expose
    private Long totalCollections;
    @SerializedName("total_likes")
    @Expose
    private Long totalLikes;
    @SerializedName("total_photos")
    @Expose
    private Long totalPhotos;
    @SerializedName("accepted_tos")
    @Expose
    private Boolean acceptedTos;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param lastName
     * @param profileImage
     * @param location
     * @param totalPhotos
     * @param links
     * @param totalCollections
     * @param id
     * @param updatedAt
     * @param totalLikes
     * @param username
     * @param bio
     * @param portfolioUrl
     * @param instagramUsername
     * @param name
     * @param acceptedTos
     * @param firstName
     * @param twitterUsername
     */
    public User(String id, String updatedAt, String username, String name, String firstName, String lastName, String twitterUsername, String portfolioUrl, String bio, String location, Links_ links, ProfileImage profileImage, String instagramUsername, Long totalCollections, Long totalLikes, Long totalPhotos, Boolean acceptedTos) {
        super();
        this.id = id;
        this.updatedAt = updatedAt;
        this.username = username;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.twitterUsername = twitterUsername;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.links = links;
        this.profileImage = profileImage;
        this.instagramUsername = instagramUsername;
        this.totalCollections = totalCollections;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.acceptedTos = acceptedTos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public Long getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Long totalCollections) {
        this.totalCollections = totalCollections;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Long totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Long getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Long totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Boolean getAcceptedTos() {
        return acceptedTos;
    }

    public void setAcceptedTos(Boolean acceptedTos) {
        this.acceptedTos = acceptedTos;
    }

}
