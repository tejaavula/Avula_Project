package net.javaguides.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.cms.entity.Course;
import net.javaguides.cms.service.CourseService;

@Controller
public class CourseController {
private CourseService courseService;
public CourseController(CourseService courseService) {
	super();
	this.courseService = courseService;
}
@GetMapping("/courses")
public String listCourses(Model model) {
	model.addAttribute("courses", courseService.getAllCourses());
	return "courses";
}
@GetMapping("/courses/new")
public String createCourseForm(Model model) {
	
	// create course object to hold course form data
	Course course = new Course();
	model.addAttribute("course", course);
	return "create_course";
	
}
@PostMapping("/courses")
public String saveCourse(@ModelAttribute("course") Course course) {
	courseService.saveCourse(course);
	return "redirect:/courses";
}

@GetMapping("/courses/edit/{id}")
public String editCourseForm(@PathVariable Long id, Model model) {
	model.addAttribute("course",courseService.getCourseById(id));
	return "edit_course";
}
@PostMapping("/courses/{id}")
public String updateCourse(@PathVariable Long id,
		@ModelAttribute("course") Course course,
		Model model) {
	
	// get student from database by id
	Course existingCourse = courseService.getCourseById(id);
	existingCourse.setId(id);
	existingCourse.setCourseName(course.getCourseName());
	existingCourse.setFacultyName(course.getFacultyName());
	existingCourse.setEmail(course.getEmail());
	
	// save updated student object
	courseService.updateCourse(existingCourse);
	return "redirect:/courses";		
}
@GetMapping("/courses/{id}")
public String deleteCourse(@PathVariable Long id) {
	courseService.deleteCourseById(id);
	return "redirect:/courses";
}

}
