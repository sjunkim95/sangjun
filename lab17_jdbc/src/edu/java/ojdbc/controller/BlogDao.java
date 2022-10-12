package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

public interface BlogDao {
    
    List<Blog> select(); // SQL_SELECT_ALL
    Blog select(Integer blogNo); // SQL_SELECT_BY_NO
   // int insert(String title, String content, String author); // SQL_INSERT
    //위에 대신에
    int insert(Blog blog); // SQL_INSERT
   // int update(int no, String title, String content) 보다는
    int update(Blog blog); // SQL_UPDATE
    int delete(Integer blogNo); // SQL_DELETE
    
}
