package net.lyh.web;

public class User {
    private int id;
    private String name;
    private String host;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public User(int id, String name, String host) {
        this.id = id;
        this.name = name;
        this.host = host;
    }
}
