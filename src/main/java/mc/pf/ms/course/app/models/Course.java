package mc.pf.ms.course.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "courses")
public class Course {
	@Id
	private String id;

	private String course;
}
