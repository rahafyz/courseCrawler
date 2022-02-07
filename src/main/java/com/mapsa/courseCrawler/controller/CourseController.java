package com.mapsa.courseCrawler.controller;

import com.mapsa.courseCrawler.service.CourseService;
import com.mapsa.courseCrawler.view.CourseView;

import java.util.Collections;

public class CourseController {
    private CourseView courseView;

    public CourseController() {
        this.courseView = new CourseView();
    }

    public void run(){
        courseView.printCourses(Collections.singletonList(CourseService.courses()));
    }
}
