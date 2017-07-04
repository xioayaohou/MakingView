package com.example.view.tongxunlu;

/**
 * Created by 20160903 on 2016/12/24.
 */

public class Selfphone {
    private int id;
    String title;
    String name;
    String selfphone;

    public Selfphone(int id, String title, String name, String selfphone) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.selfphone = selfphone;
    }

    public Selfphone(String title, String name, String selfphone) {
        this.title = title;
        this.name = name;
        this.selfphone = selfphone;
    }

    public Selfphone(String title, String name) {
        this.title = title;
        this.name = name;
    }



    public Selfphone() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelfphone() {
        return selfphone;
    }

    public void setSelfphone(String selfphone) {
        this.selfphone = selfphone;
    }


    @Override
    public String toString() {
        return "Selfphone{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", selfphone='" + selfphone + '\'' +
                '}';
    }
}
