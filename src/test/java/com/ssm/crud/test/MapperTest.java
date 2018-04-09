package com.ssm.crud.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.crud.bean.Department;
import com.ssm.crud.bean.Employee;
import com.ssm.crud.dao.DepartmentMapper;
import com.ssm.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void saveTest() {
		System.out.println(departmentMapper);
		
//		Department dept = new Department();
//		dept.setDeptName("销售部");
//		departmentMapper.insertSelective(dept);
//		
//		Employee emp = new Employee();
//		emp.setEmpName("小明");
//		emp.setGender("F");
//		emp.setEmail("xiaoming@163.com");
//		emp.setdId(1);
//		
//		employeeMapper.insertSelective(emp);
		
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<=1000;i++) {
			 String uuid = UUID.randomUUID().toString().substring(0, 6);
			Employee emp = new Employee();
			emp.setEmpName(uuid);
			emp.setGender("F");
			emp.setEmail(uuid+"@163.com");
			emp.setdId(1);
			employeeMapper.insertSelective(emp);
		}
	
	}
	
	
}
