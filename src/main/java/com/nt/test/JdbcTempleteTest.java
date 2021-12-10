package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.EmployeeDAOImpl;

public class JdbcTempleteTest {
public static void main(String[] args) {
	ApplicationContext ctx=null;
	EmployeeDAOImpl emp=null;
	//create container
	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	
	//get bean
	try {
		emp=ctx.getBean("empDao",EmployeeDAOImpl.class);
		int count=emp.countEmp();
		System.out.println(count);
		System.out.println("------------");
		String name=emp.getEmpNameById(101);
		System.out.println(name);
		System.out.println("------------");
		Map<String,Object> empdt=emp.GetEmpDetails(101);
		System.out.println("Details for employee no 101 are-->"+empdt);
		System.out.println("--------------");
		List<Map<String,Object>> listemp = emp.getEmpDetailsByDesg("Web Developer","Python","Java Developer");
	    System.out.println(listemp);
	    int count1=emp.deleteEmployee(333);
	   System.out.println(count1+" record deleted...");
	   System.out.println("----------------");
	   int count2= emp.updateSalary(50000,"java");
	   System.out.println(count2+"records updaed...");
	}
	catch(DataAccessException e) {
		e.printStackTrace();
	}
}
}
