package net.javaguides.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.cms.entity.Course;
import net.javaguides.cms.repository.CourseRepository;
import net.javaguides.cms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	private CourseRepository courseRepository;
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
@Override
public List<Course> getAllCourses(){
	return courseRepository.findAll();
}
@Override
public Course saveCourse(Course course) {
	// TODO Auto-generated method stub
	return courseRepository.save(course);
}
@Override
public Course getCourseById(Long id) {
	// TODO Auto-generated method stub
	return courseRepository.findById(id).get();
}
@Override
public Course updateCourse(Course course) {
	// TODO Auto-generated method stub
	return courseRepository.save(course);
}
@Override
public void deleteCourseById(Long id) {
	// TODO Auto-generated method stub
	courseRepository.deleteById(id);
	
}
}
 