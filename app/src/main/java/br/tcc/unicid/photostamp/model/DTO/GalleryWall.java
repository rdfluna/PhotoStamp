package br.tcc.unicid.photostamp.model.DTO;

import java.util.ArrayList;

public class GalleryWall {
    private int ID;
    private ArrayList<Photo> photos;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}