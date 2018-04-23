package br.tcc.unicid.photostamp.model.DTO;

import java.util.ArrayList;
import java.util.Date;

public class Photo {
    private int ID;
    private int userID;
    private String name;
    private ArrayList<Tag> tags;
    private String extension;
    private int size;
    private Date dateModificaiton;
}