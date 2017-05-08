package com.example.administrator.yangjinyang20170504;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class MyCar {
    private String name;
    private String price;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
