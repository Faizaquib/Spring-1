package com.ssi;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {

	//to add a new student 
	@RequestMapping("newStudent")
	public String AddStudent(@ModelAttribute("info") StudentModel model)
	{
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		session.save(model);
		tr.commit();
		session.close();
		System.out.println("Data Feeded!");
		return "index.jsp";
	}
	
	//to serach a student by its roll number
	@RequestMapping("findStudent")
	public ModelAndView SearchStudent(@requestParameter("id") int rollno)
	{
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		ModelAndView mv = new ModelAndView("SearchStudent.jsp")
		
		StudentModel student = new StudentModel();
		student= session.get(StudentModel.class, rollno);
		System.out.println(student);
		mv.addObject(student);
		return mv;
	}
	
	//to view all the students available
	@RequestMapping("AllStudent")
	public  ModelAndView AllStudent(){
		
		Configuration config= new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Query<R> query = session.createSQLQuery("from student");
		List<StudentModel> list = (StudentModel) query.list();
		for(StudentModel sm : list)
		{
			System.out.println("["+sm.getId()+","+sm.getName()+","+sm.getMarks()+","+sm.getPhno()+"]");
		}
		tr.commit();
		session.close();
	}
	
	
}
