package com.et.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午9:03:42      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {
   @Resource
   private BaseDao<T> baseDao;

   @Override
   public void saveOrUpdate(T t) {
      getBaseDao().saveOrUpdate(t);

   }

   @Override
   public void delete(T t) {
      getBaseDao().delete(t);

   }

   @Override
   public void deleteById(Long id) {
      getBaseDao().deleteById(id);
   }

   @Override
   public void deleteByIds(Long[] ids) {
      getBaseDao().deleteByIds(ids);
   }

   @Override
   public List<T> getAll() {
      return getBaseDao().getAll();
   }

   @Override
   public T getById(Long id) {
      return getBaseDao().getById(id);
   }

   @Override
   public List<T> getByIds(Long[] ids) {
      return getBaseDao().getByIds(ids);
   }

   @Override
   public List<T> getByPage(int first, int MaxResults) {
      return getBaseDao().getByPage(first, MaxResults);
   }

   @Override
   public List<T> getByPageNum(int pageNumber, int pageResults) {
      return getBaseDao().getByPageNum(pageNumber, pageResults);
   }

   public BaseDao<T> getBaseDao() {
      return baseDao;
   }

   public void setBaseDao(BaseDao<T> baseDao) {
      this.baseDao = baseDao;
   }

}
