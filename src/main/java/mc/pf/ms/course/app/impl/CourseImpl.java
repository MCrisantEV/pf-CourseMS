package mc.pf.ms.course.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.pf.ms.course.app.models.Course;
import mc.pf.ms.course.app.repositories.CourseRepository;
import mc.pf.ms.course.app.services.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseImpl implements CourseService {

	@Autowired
	private CourseRepository coRep;

	@Override
	public Flux<Course> saveAll(List<Course> lstCourses) {
		return Flux.fromIterable(lstCourses).flatMap(lst -> {
			return error(lst);
		});
	}

	@Override
	public Mono<Course> save(Course course) {
		return error(course);
	}

	@Override
	public Flux<Course> findAll() {
		return coRep.findAll();
	}

	@Override
	public Mono<Course> findId(String id) {
		return coRep.findById(id);
	}

	@Override
	public Mono<Course> findCourse(String course) {
		return coRep.findByCourse(course);
	}
	
	public Mono<Course> error(Course obj){
		if (obj.getCourse().equals("") || obj.getCourse() == null) {
			obj.setCourse("No registrado, puede ser vacio");
			return Mono.just(obj);
		} else {
			return coRep.findByCourse(obj.getCourse()).map(db -> {
				obj.setCourse(obj.getCourse() + ", Ya esta registrado");
				return obj;
			}).switchIfEmpty(coRep.save(obj));
		}
	}

}
