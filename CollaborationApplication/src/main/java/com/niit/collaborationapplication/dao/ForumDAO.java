package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.Forum;


public interface ForumDAO {
	public boolean createForum(Forum forum);
	public boolean deleteForum(String forumID);
	public Forum getForumByID(String forumID);
	public List<Forum> listAllForums();
	public boolean updateForum(Forum forum);
}
