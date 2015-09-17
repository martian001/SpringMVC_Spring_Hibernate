package com.et.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月13日 上午10:09:50      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */

public class HibernateUtil {
   private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
   private static Transaction beginTransaction;
   private static SessionFactory sessionFactory;

   static {
      Configuration configure = new Configuration().configure("com/et/test/hibernate.cfg.xml");
      sessionFactory = configure.buildSessionFactory();
   }

   public static Session getSession() {
      Session openSession = null;
      if (threadLocal.get() == null) {
         openSession = sessionFactory.openSession();
         threadLocal.set(openSession);
      }
      openSession = threadLocal.get();
      beginTransaction = openSession.beginTransaction();
      return openSession;
   }

   public static void close() {
      beginTransaction.commit();
      threadLocal.get().close();
   }
}
