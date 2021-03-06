package com.carsim.core.repo;

import java.util.List;

import com.carsim.core.model.entities.Blog;

/**
 * Created by webyildirim on 7/10/14.
 */
public interface BlogRepo {
    public Blog createBlog(Blog data);
    public List<Blog> findAllBlogs();
    public Blog findBlog(Long id);
    public Blog findBlogByTitle(String title);
    public List<Blog> findBlogsByAccount(Long accountId);
}
