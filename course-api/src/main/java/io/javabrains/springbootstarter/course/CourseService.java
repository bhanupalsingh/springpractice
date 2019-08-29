package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseService;

	
	public List<Course> getAllCourses(String id){
		List<Course> courses = new ArrayList<Course>();
		courseService.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		return courseService.findById(id).get();
	}


	public void addCourse(Course course){
		courseService.save(course);
	}
	
	public void updateCourse(Course course){
		courseService.save(course);
	}
	
	public void deleteCourse(String id){
		courseService.deleteById(id);
	}
}
