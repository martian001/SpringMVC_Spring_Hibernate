package com.et.base;

import java.util.List;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:30:31      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public interface BaseDao<T> {
   /**
    * 增加后修改一个对象
    * @param t
    */
   void saveOrUpdate(T t);

   /**
    * 删除对象
    * @param t
    */
   void delete(T t);

   /**
    * 根据id删除对象
    * @param t
    */
   void deleteById(Long id);

   /**
    * 根据id数组删除多个对象
    * @param t
    */
   void deleteByIds(Long[] ids);

   /**
    * 查询所有对象
    * @return
    */
   List<T> getAll();

   /**
    * 根据id查询对象
    * @param id
    * @return
    */
   T getById(Long id);

   /**
    * 根据id数组查询多个对象
    * @param id
    * @return
    */
   List<T> getByIds(Long[] ids);

   /**
    * 根据开始位置和结束位置进行分页
    * @param first
    * @param MaxResults
    * @param c
    * @return
    */
   List<T> getByPage(int first, int MaxResults);

   /**
    * 根据页码和一页的数量，返回数据
    * @param pageNumber
    * @param pageResults
    * @param c
    * @return
    */
   List<T> getByPageNum(int pageNumber, int pageResults);
}
