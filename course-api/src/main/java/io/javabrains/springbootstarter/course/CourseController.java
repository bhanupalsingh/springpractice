package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/topic/{id}/courses",method=RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.GET)
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses",method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.PUT)
	public void updateCourse(@PathVariable String id,@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}	
}
