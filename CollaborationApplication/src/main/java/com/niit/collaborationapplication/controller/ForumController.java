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

import com.niit.collaborationapplication.dao.ForumDAO;
import com.niit.collaborationapplication.model.Forum;


@RestController
public class ForumController {

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);
	
	@Autowired
	Forum forum;
	
	@Autowired
	ForumDAO forumDAO;
	
	@RequestMapping(value="/listAllForums",method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> listAllForums(){
		logger.debug("->->->->Calling method listAllForums");
		List<Forum> forumlist = forumDAO.listAllForums();
		if(forumlist.isEmpty()){
			return new ResponseEntity<List<Forum>>(forumlist,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(forumlist,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getForumByID/{forumID}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForumByID(@PathVariable("forumID") String forumID){
		logger.debug("->->->->Calling method getForumByID");
		this.forum = forumDAO.getForumByID(forumID);
		if(forum==null){
			logger.debug("Forum with forumID: '"+forumID+"' not found");
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<Forum>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/createForum/",method=RequestMethod.POST)
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum,UriComponentsBuilder ucBuilder){
		logger.debug("->->->->Calling method postForum");
		
		System.out.println(forum);
		
		//forum.setForumID("BLG");
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forum.setCreatedAt(timestamp);
		forum.setModifiedAt(timestamp);
		forum.setStatus('P');
		
		forumDAO.createForum(forum);
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setLocation(ucBuilder.path("/forum/{forumID}").buildAndExpand(forum.getForumID()).toUri());
		return new ResponseEntity<Forum>(httpHeaders,HttpStatus.CREATED);  
	}
	
	@RequestMapping(value="/updateForum/{forumID}",method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@PathVariable("forumID") String forumID,@RequestBody Forum forum){
		this.forum = forumDAO.getForumByID(forumID);
		if(this.forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);  
		}
		this.forum.setForumName(forum.getForumName());
		this.forum.setForumDescription(forum.getForumDescription());
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		this.forum.setModifiedAt(timestamp);
		forumDAO.updateForum(forum);
		return new ResponseEntity<Forum>(this.forum,HttpStatus.OK); 
	}
	
	@RequestMapping(value="/deleteForum/{forumID}",method=RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteForum(@PathVariable("forumID") String forumID){
		this.forum = forumDAO.getForumByID(forumID);
		if(this.forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forumDAO.deleteForum(forumID);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT); 
	}
	
}
