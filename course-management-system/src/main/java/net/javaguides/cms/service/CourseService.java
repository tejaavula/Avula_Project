package net.javaguides.cms.service;

import java.util.List;

import net.javaguides.cms.entity.Course;

public interface CourseService {
           List<Course> getAllCourses();
           Course saveCourse(Course course);
           Course getCourseById(Long id);
           Course updateCourse(Course course);
           void deleteCourseById(Long id);
}
