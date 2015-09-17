package com.et.test;

import java.util.List;

import com.et.bean.Student;
import com.et.util.HibernateUtil;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午10:01:50      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Test {

   @org.junit.Test
   public void test2() {
      List<Student> queryByPage = HibernateUtil.getSession().createQuery("from Student").list();
      for (Student user : queryByPage) {
         System.out.println(user);
      }
   }

   @org.junit.Test
   public void testDelete() {
      Student student = new Student(null, "11", 21);
      HibernateUtil.getSession().saveOrUpdate(student);
      HibernateUtil.close();
   }

}
