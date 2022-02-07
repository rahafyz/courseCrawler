package com.mapsa.courseCrawler.model.crawler;

import com.mapsa.courseCrawler.model.Course;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class EdX implements Runnable{

    private List<Course> courses;

    public EdX() {
        courses = new ArrayList<>();
    }

    @Override
    public void run() {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.edx.org/learn/java")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                    .timeout(25000)
                    .get();

            Elements course = doc.getElementsByClass("discovery-card-link bg-white text-black");

            for (Element element : course) {
                Element t = element.getElementsByClass("h4 text-black").get(0);
                Element a = element.getElementsByTag("a").get(0);
                String title = t.text();
                String link = a.attr("href");

                Course newCourse = new Course();
                newCourse.setTitle(title);
                newCourse.setLink("https://www.edx.org"+link);

                courses.add(newCourse);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getCourses() {
        return courses;
    }
}
