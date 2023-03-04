package io.javabrains.springstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllcourses();
	}
	
	@RequestMapping("/courses/{foo}")
	public Optional<Course> getcourse(@PathVariable("foo") String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/courses")
	void addCourse(@RequestBody Course course){
		courseService.addCourse(course);
		}
	
	@RequestMapping(method=RequestMethod.PUT,value="/courses/{id}")
	void updateCourse(@RequestBody Course course,@PathVariable() String id){
		courseService.updateCourse(id,course);
		}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/courses/{id}")
	void updateCourse(@PathVariable() String id){
		courseService.deleteCourse(id);
		}
	
}
