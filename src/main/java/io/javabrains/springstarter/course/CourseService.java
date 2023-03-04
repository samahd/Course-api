package io.javabrains.springstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
//	private List<Course> courses = new ArrayList<> (Arrays.asList(
//			new Course("String","String name","Spring description"),
//			new Course("Spring","Salman","Salman description"),
//			new Course("Java","Java name","Java description"),
//			new Course("Str","Str name","Sar description")
//			));
	public List<Course> getAllcourses() {
		return (List<Course>) repository.findAll();
		
	}
	
	public Optional<Course> getCourse(String id) {
		return repository.findById(id);
		//return courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
		}

	public void addCourse(Course course) {
		//courses.add(course);
		repository.save(course);
		
	}

	public void updateCourse(String id, Course course) {
		repository.save(course);
	}
		
	public void deleteCourse(String id) {
		repository.deleteById(id);
		
//		for(int i=0; i<courses.size();i++) {
//			Course t=courses.get(i);
//			if(t.getId().equals(id)) {
//				courses.set(i,course);
//				return;
//			}
//		}
		
	}

}
