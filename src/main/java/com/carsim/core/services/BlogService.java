package com.carsim.core.services;

import com.carsim.core.model.entities.Blog;
import com.carsim.core.model.entities.BlogEntry;
import com.carsim.core.services.util.BlogEntryList;
import com.carsim.core.services.util.BlogList;

/**
 * Created by webyildirim on 6/28/14.
 */
public interface BlogService {
    /**
     * @param blogId the id of the blog to add this BlogEntry to
     * @param data the BlogEntry containing the data to be used for creating the new entity
     * @return the created BlogEntry with a generated ID
     * @throws carsim.core.EntityNotFoundException.exceptions.BlogNotFoundException if the blog to add to cannot be found
     */
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();

    public BlogEntryList findAllBlogEntries(Long blogId); // findBlog all associated blog entries

    public Blog findBlog(Long id);
}
