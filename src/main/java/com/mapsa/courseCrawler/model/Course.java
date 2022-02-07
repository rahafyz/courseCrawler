package com.mapsa.courseCrawler.model;

public class Course {
    private String title;
    private String link;



    public void setTitle(String title) {
        this.title = title;
    }


    public void setLink(String link) {
        this.link = link;
    }



    @Override
    public String toString() {
        return
                "title= " + title + '\'' +
                "link= " + link + '\'' +
                "\n";
    }
}
