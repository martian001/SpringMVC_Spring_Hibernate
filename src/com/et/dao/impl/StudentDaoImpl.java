package com.et.dao.impl;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.et.base.BaseDaoImpl;
import com.et.bean.Student;
import com.et.dao.StudentDao;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:33:38      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

   public StudentDaoImpl() {
      System.out.println("UserDaoImpl实例化");
   }

   @Override
   public boolean nameIsExist(String name) {
      Session session = getHibernateTemplate().getSessionFactory().openSession();
      Query query = session.createQuery("from Student s where name=:name");
      query.setParameter("name", name);
      boolean bool = query.uniqueResult() != null;
      session.close();
      return bool;
   }

   public static void main(String[] args) {
      StudentDao dao = new StudentDaoImpl();
   }

}
