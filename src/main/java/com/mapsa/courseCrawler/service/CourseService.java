package com.mapsa.courseCrawler.service;

import com.mapsa.courseCrawler.model.Course;
import com.mapsa.courseCrawler.model.crawler.Coursera;
import com.mapsa.courseCrawler.model.crawler.EdX;
import com.mapsa.courseCrawler.model.crawler.Faradars;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static Coursera coursera;
    private static EdX edX;
    private static Faradars faradars;
    private static List<Course> courses;

    static  {
        courses = new ArrayList<>();
        coursera = new Coursera();
        edX = new EdX();
        faradars = new Faradars();
    }

    private static void threadRunner(){
        try {
            Thread tUdemy = new Thread(coursera);
            tUdemy.start();
            Thread tedX = new Thread(edX);
            tedX.start();
            Thread tFaradars = new Thread(faradars);
            tFaradars.start();
            tUdemy.join();
            tedX.join();
            tFaradars.join();

            courses.addAll(coursera.getCourses());
            courses.addAll(edX.getCourses());
            courses.addAll(faradars.getCourses());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Course> courses(){
        threadRunner();
        return courses;
    }
}
