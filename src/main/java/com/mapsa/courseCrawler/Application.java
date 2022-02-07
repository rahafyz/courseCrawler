package com.mapsa.courseCrawler;

import com.mapsa.courseCrawler.controller.CourseController;
import com.mapsa.courseCrawler.model.crawler.Coursera;
import com.mapsa.courseCrawler.model.crawler.EdX;
import com.mapsa.courseCrawler.model.crawler.Faradars;

public class Application {
    public static void main(String[] args) {
        CourseController controller = new CourseController();
        controller.run();

    }
}
