package com.mahmoudrabie.sql;

public class model {
    public String name,desc,url;
    public int id;

    public model() {
    }

    public model(String name, String desc, String url, int id) {
        this.name = name;
        this.desc = desc;
        this.url = url;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }
}
