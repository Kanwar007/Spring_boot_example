package com.kanwar.study.restapi.services;

import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.kanwar.study.restapi.pojo.Student;

import org.springframework.stereotype.Component;

@Component
public class StudentServices {
    private Student student;
    private  static List<Student> studentList = new ArrayList<Student>();
    private static int count =4;
    static{
        studentList.add(new Student(1,"Vijay","KAnwar", new Date(), "Perth"));
        studentList.add(new Student(2,"Sonam","Bala", new Date(), "Bilaspur"));
        studentList.add(new Student(3,"Avyukt","KAnwar", new Date(), "Australia"));
        studentList.add(new Student(4,"Ajay","KAnwar", new Date(), "Delhi"));
       
    }
    
    public List<Student> getAllStudent(){
    
        return studentList;
    }
    public Student getStudent(int id) {
      
        for (Student student : studentList) {
            if(student.getStudentId() == id){
                this.student= student;
            }
            
        }
        return this.student;
    }
    public Student saveStudent(Student student){
       if(student== null){
           return null;
       }
        student.setStudentId(++count);
        studentList.add(student);
        return student;
    }
    
    public Student deleteStudent(int  studentID){
        Iterator<Student> iterable =  studentList.iterator();
          while(iterable.hasNext()){
            Student student =  iterable.next();
              if( student.getStudentId() == studentID){
                iterable.remove();
                return student;
              }

          }
          
      
       
        
        return null;
    }
    
}
