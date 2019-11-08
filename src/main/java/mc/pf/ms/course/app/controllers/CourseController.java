package mc.pf.ms.course.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mc.pf.ms.course.app.models.Course;
import mc.pf.ms.course.app.services.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService coServ;
	
	@PostMapping("/all")
	public Flux<Course> createAll(@RequestBody List<Course> lstCourses){
		return coServ.saveAll(lstCourses);
	}
	
	@PostMapping()
	public Mono<Course> create(@RequestBody Course course){
		return coServ.save(course);
	}
	
	@GetMapping
	public Flux<Course> findAll(){
		return coServ.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Course> findId(@PathVariable String id){
		return coServ.findId(id);
	}
	
	@GetMapping("/name/{course}")
	public Mono<Course> findCourse(@PathVariable String course){
		return coServ.findCourse(course);
	}

}
