package mc.pf.ms.course.app.services;

import java.util.List;

import mc.pf.ms.course.app.models.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {
	
	public Flux<Course> saveAll(List<Course> lstCourses);
	public Mono<Course> save(Course course);
	public Flux<Course> findAll();
	public Mono<Course> findId(String id);
	public Mono<Course> findCourse(String course);
}
