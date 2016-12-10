package com.niit.collaborationapplication.controller;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborationapplication.dao.BlogCommentDAO;
import com.niit.collaborationapplication.dao.BlogDAO;
import com.niit.collaborationapplication.model.Blog;
import com.niit.collaborationapplication.model.BlogComment;

@RestController
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);  

	@Autowired
	Blog blog;
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	BlogComment blogComment;
	
	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	@RequestMapping(value="/getBlogByCreatedAt",method=RequestMethod.GET)
	public ResponseEntity<List<Blog>> listBlogsByCreatedAt(){
		logger.debug("->->->->Calling method listAllBlogs");
		List<Blog> listOfBlog1 = blogDAO.listBlogByCreatedAt('A');
		if(listOfBlog1.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBlogByID/{blogID}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlogByID(@PathVariable("blogID") String blogID){
		logger.debug("->->->->Calling method getBlogByID");
		this.blog = blogDAO.getBlogByID(blogID);
		if(blog==null){
			logger.debug("Blog with blogID: '"+blogID+"' not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/postBlog",method=RequestMethod.POST)
	public ResponseEntity<Blog> postBlog(@RequestBody Blog blog,UriComponentsBuilder ucBuilder){
		logger.debug("->->->->Calling method postBlog");
		
		System.out.println(blog);
		
		blog.setBlogID("BLG");
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		blog.setCreatedAt(timestamp);
		blog.setModifiedAt(timestamp);
		blog.setStatus('P');
		
		blogDAO.postBlog(blog);
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setLocation(ucBuilder.path("/blog/{blogID}").buildAndExpand(blog.getBlogID()).toUri());
		return new ResponseEntity<Blog>(httpHeaders,HttpStatus.CREATED);  
	}
	
	@RequestMapping(value="/updateBlog",method=RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("blogID") String blogID,@RequestBody Blog blog){
		this.blog = blogDAO.getBlogByID(blogID);
		if(this.blog==null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);  
		}
		this.blog.setBlogName(blog.getBlogName());
		this.blog.setBlogDescription(blog.getBlogDescription());
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		this.blog.setModifiedAt(timestamp);
		blogDAO.postBlog(blog);
		return new ResponseEntity<Blog>(this.blog,HttpStatus.OK); 
	}
	
	@RequestMapping(value="/deleteBlog",method=RequestMethod.DELETE)
	public ResponseEntity<Blog> deleteBlog(@PathVariable("blogID") String blogID){
		this.blog = blogDAO.getBlogByID(blogID);
		if(this.blog==null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.deleteBlog(blogID);
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT); 
	}
	
}
