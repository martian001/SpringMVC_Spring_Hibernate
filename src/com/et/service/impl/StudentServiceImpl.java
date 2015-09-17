package com.et.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.et.base.BaseServiceImpl;
import com.et.bean.Student;
import com.et.dao.StudentDao;
import com.et.service.StudentService;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午9:09:01      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
   @Resource
   private StudentDao studentDao;

   public StudentServiceImpl() {
      System.out.println("StudentServiceImpl.StudentServiceImpl()");
   }

   public StudentDao getStudentDao() {
      return studentDao;
   }

   public void setStudentDao(StudentDao studentDao) {
      this.studentDao = studentDao;
      System.out.println("StudentServiceImpl.setStudentDao()");
   }

   @Override
   public boolean nameIsExist(String name) {
      return studentDao.nameIsExist(name);
   }
}
