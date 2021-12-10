package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl {
private JdbcTemplate jt;
private static final String EMP_COUNT_QUERY="SELECT COUNT(*) FROM EMP";
private static final String EMP_NAME_QUERY="SELECT ENAME FROM EMP WHERE ENO=?";
private static final String EMP_DETAILS ="SELECT ENO,ENAME,EJOB,ESAL FROM EMP WHERE ENO=?";
private static final String EMP_DETAILS_BY_DESG ="SELECT ENO,ENAME,EJOB,ESAL FROM EMP WHERE EJOB IN(?,?,?)";
private static final String DELETE_EMP_BY_ID ="DELETE FROM EMP WHERE ENO=?";
private static final String UPDATE_EMP_SAL ="UPDATE EMP SET ESAL=ESAL+? WHERE EJOB=?";
public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
}

public int countEmp() {
	int count=jt.queryForObject(EMP_COUNT_QUERY, Integer.class);
	return count;
}

public String getEmpNameById(int eno) {
	String name=jt.queryForObject(EMP_NAME_QUERY,String.class,eno);
	return name;
}

public Map<String,Object> GetEmpDetails(int eno){
	Map<String,Object> details=jt.queryForMap(EMP_DETAILS,eno);
	return details;
}

public List<Map<String,Object>> getEmpDetailsByDesg(String desg1,String desg2,String desg3){
	List<Map<String,Object>> listmap=jt.queryForList(EMP_DETAILS_BY_DESG,desg1,desg2,desg3);
	return listmap;
}

public int deleteEmployee(int eno) {
	
	int count=jt.update(DELETE_EMP_BY_ID,eno);
	return count;
}

public int updateSalary(float salary,String desg) {

	int count=jt.update(UPDATE_EMP_SAL,salary,desg);
	return count;
}

}
