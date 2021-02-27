package com.example.makeupstyle;

import java.io.Serializable;

public class ModelClass implements Serializable {
    String photo;
    String name_sub;
    String desc, name_makeup, image_makeup, image_sub, phase_image;
    int id_makeup, id_sub, id_detail, id_photo;


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ModelClass(String photo, int id_photo){
        this.id_photo = id_photo;
        this.photo = photo;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public String getPhase_image() {
        return phase_image;
    }

    public void setPhase_image(String phase_image) {
        this.phase_image = phase_image;

    }

    public ModelClass(String name, String image, int id){
        this.name_sub = name;
        this.image_sub = image;
        this.id_sub = id;
    }

    public ModelClass(int i, String phase_image){
        this.phase_image = phase_image;
        this.id_detail = i;
    }

    public ModelClass(int id, String name, String image, String desc){
        this.name_makeup = name;
        this.image_makeup = image;
        this.desc = desc;
        this.id_makeup = id;
    }



    public String getName_makeup() {
        return name_makeup;
    }

    public void setName_makeup(String name_makeup) {
        this.name_makeup = name_makeup;
    }

    public String getName_sub() {
        return name_sub;
    }

    public void setName_sub(String name_sub) {
        this.name_sub = name_sub;
    }

    public String getImage_makeup() {
        return image_makeup;
    }

    public void setImage_makeup(String image_makeup) {
        this.image_makeup = image_makeup;
    }

    public String getImage_sub() {
        return image_sub;
    }

    public void setImage_sub(String image_sub) {
        this.image_sub = image_sub;
    }

    public int getId_makeup() {
        return id_makeup;
    }

    public void setId_makeup(int id_makeup) {
        this.id_makeup = id_makeup;
    }

    public int getId_sub() {
        return id_sub;
    }

    public void setId_sub(int id_sub) {
        this.id_sub = id_sub;
    }
}
