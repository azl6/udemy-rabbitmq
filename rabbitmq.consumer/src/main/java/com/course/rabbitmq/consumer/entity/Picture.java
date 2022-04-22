package com.course.rabbitmq.consumer.entity;

public class Picture {

    private String name;
    private String type;
    private String source;
    private String size;

    public Picture(String name, String type, String source, String size) {
        this.name = name;
        this.type = type;
        this.source = source;
        this.size = size;
    }

    public Picture() {
    }

    @Override
    public String toString() {
        return "Picture{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
