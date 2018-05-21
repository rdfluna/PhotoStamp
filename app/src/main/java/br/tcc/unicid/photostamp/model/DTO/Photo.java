package br.tcc.unicid.photostamp.model.DTO;

import java.util.ArrayList;
import java.util.Date;

public class Photo {
    private int ID;
    private int userID;
    private String name;
    private String path;
    private ArrayList<Tag> tags;
    private String extention;
    private int size;
    private Date dateModificaiton;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getDateModificaiton() {
        return dateModificaiton;
    }

    public void setDateModificaiton(Date dateModificaiton) {
        this.dateModificaiton = dateModificaiton;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}