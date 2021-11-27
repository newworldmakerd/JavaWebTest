package net.lyh.web.domain;

public class Config {
    String url;
    String topic;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Config(String url, String topic) {
        this.url = url;
        this.topic = topic;
    }

    public Config() {
    }
}
