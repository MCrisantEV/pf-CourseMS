package mc.pf.ms.course.app.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import mc.pf.ms.course.app.models.Course;
import reactor.core.publisher.Mono;

public interface CourseRepository extends ReactiveMongoRepository<Course, String>{
	public Mono<Course> findByCourse(String course);
}
