package com.vegitab.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vegitab.model.Student;

//@Controller
@RestController
public class StudentController {
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String appDetails() {
		return appName+"-"+appVersion;
	}
       //localhost:8080/student
	//@RequestMapping(value="/student",method=RequestMethod.GET)
	@GetMapping("/student") //Get API
	//@ResponseBody
	public String getStudent() {    //Handler method
		return "Display the Student";
	}
	//localhost:8080/student/5
	@GetMapping("/student/{rollno}") //PathVariable API
	public String getStudentByRollNo(@PathVariable("rollno")int rollNo) {
		return "Display the Student by using roll number :"+rollNo;
	}
	//localhost:8080/student?rollno=21
	@DeleteMapping("/student") //On browser we can check only Get Requests not to check Post and Delete Requests.So we move on "Postman"
	public String deleteByRollno(@RequestParam("rollno")int rollNo) {
		return "Deleting a student by using rollNo given by User :"+rollNo;
	}
	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) { //@RequestBody holds the all informations came from Postman Body
		return "Save student deatails to the DataBase"+student;
	}
	@PutMapping("/student/{rollno}")
	public Student updateEmployee(@PathVariable("rollno")int rollNo,@RequestBody Student student) {
		System.out.println("This API returns student in the form of JSON"+rollNo);
		return student;
	}
}
