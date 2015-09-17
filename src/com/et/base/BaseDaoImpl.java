package com.et.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:32:19      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
   @Resource
   private HibernateTemplate hibernateTemplate;

   private Class<T> clazz;

   public HibernateTemplate getHibernateTemplate() {
      return hibernateTemplate;
   }

   public BaseDaoImpl() {
      // 通过反射技术得到T的真是类型
      ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();// 获取当前new对象 的泛型的 父类类型
      clazz = (Class<T>) pt.getActualTypeArguments()[0];// 获取第一个类型参数的真实类型
   }

   @Override
   public void saveOrUpdate(T t) {
      hibernateTemplate.saveOrUpdate(t);
   }

   @Override
   public void delete(T t) {
      hibernateTemplate.delete(t);
   }

   @Override
   public List<T> getAll() {
      return hibernateTemplate.find("from " + clazz.getSimpleName());
   }

   @Override
   public T getById(Long id) {
      if (id == null) {
         return null;
      }
      return hibernateTemplate.get(clazz, id);
   }

   @Override
   public List<T> getByPage(int first, int MaxResults) {
      return null;
   }

   @Override
   public List<T> getByPageNum(int pageNumber, int pageResults) {
      return null;
   }

   @Override
   public void deleteById(Long id) {
      T t = getById(id);
      if (t != null) {
         hibernateTemplate.delete(t);
      }
   }

   @Override
   public void deleteByIds(Long[] ids) {
   }

   @Override
   public List<T> getByIds(Long[] ids) {
      return null;
   }
}
