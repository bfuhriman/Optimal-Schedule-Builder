package edu.uga.devdogs.course_information;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.uga.devdogs.course_information.Class.Class;
import edu.uga.devdogs.course_information.Class.ClassRepository;
import edu.uga.devdogs.course_information.Course.Course;
import edu.uga.devdogs.course_information.Course.CourseRepository;
import edu.uga.devdogs.course_information.CourseSection.CourseSection;
import edu.uga.devdogs.course_information.Building.Building;
import edu.uga.devdogs.course_information.CourseSection.CourseSectionRepository;
import edu.uga.devdogs.course_information.Building.BuildingRepository;
import java.sql.Time;
import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication
public class CourseInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseInformationApplication.class, args);
	}

	@Bean
    	CommandLineRunner courseSecCommandLineRunner(
			CourseSectionRepository courseSectionRepository,
			CourseRepository courseRepository, 
			ClassRepository classRepository,
			BuildingRepository buildingRepository) {
				return args -> {
					//CourseSection interface objects
					CourseSection section1 = new CourseSection (
						123456,
						4,
						'A',
						1.0,
						4.0,
						"Barnes",
						2,
						40,
						40,
						2024,
						null,
						null
					);

					courseSectionRepository.save(section1);

					System.out.println("\n\n\n\n\n\n" + courseSectionRepository.findAllByInstructor("Barnes"));

					//courseRepository interface objects
					Course course1 = new Course (
						"physiology", 
						"420", 
						"pain", 
						"Mary Francis early education",
						null
					);
					course1.setSemesters(Stream.of("Spring", "Summer").toList());
					courseRepository.save(course1);


					Course course2 = new Course (
						"math", 
						"1101", 
						"intro", 
						"Department of Mathematics",
						null
					);
					courseRepository.save(course2);
					System.out.println(courseRepository.findAllBySubject("physiology"));
					// TESTED 
					// Output:
					// [Course [courseId=1, subject=physiology, courseNumber=420, title=pain, department=Mary Francis early education]]
          
					//Building interface objects
					Building building1 = new Building ("2438", "CAGTECH", "F - 6");
					buildingRepository.save(building1);
					
					Building building2 = new Building("46", "Caldwell Hall", "C - 1");
					buildingRepository.save(building2);
					
					Building building3 = new Building("2118", "Campus Mail/Environmental Safety", "E - 6");
					buildingRepository.save(building3);
					
					Building building4 = new Building("1637", "Campus Transit Facility", "D - 8");
					buildingRepository.save(building4);
					
					Building building5 = new Building("31", "Candler Hall", "C - 1");
					buildingRepository.save(building5);
					
					Building building6 = new Building("1110", "Carlton Street Deck", "B - 4");
					buildingRepository.save(building6);
					
					Building building7 = new Building("2419", "CCRC", "E - 7");
					buildingRepository.save(building7);
					
					Building building8 = new Building("2127", "Center for Applied Isotope Study", "E - 6");
					buildingRepository.save(building8);
					
					Building building9 = new Building("2395", "Center for Molecular Medicine", "E - 7");
					buildingRepository.save(building9);
					
					Building building10 = new Building("178", "Central Campus Mech. Building", "C - 2");
					buildingRepository.save(building10);

					System.out.println("\n\n\n\n\n"+buildingRepository.findById("178"));


					//Class interface objects
					Class class1 = new Class(
							"MWF", 
							"08:00:00",
							"09:15:00",
							building10, 
							"101", 
							"Main Campus" ,
							null
					);

					Class class2 = new Class(
							"TR", 
							"13:00:00", 
							"14:15:00", 
							building6,  
							"205", 
							"North Campus",
							null
					);

				classRepository.save(class1);
				classRepository.save(class2);
				List<Course> springCourses = courseRepository.findAllBySemester("Spring");
				System.out.println("All courses with spring semesters: " + springCourses.toString());
			};
		}


}

