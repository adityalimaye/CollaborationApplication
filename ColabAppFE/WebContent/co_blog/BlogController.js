/**
 * 
 */
'use strict';
app.controller('BlogController',['$scope','BlogService','$location','$rootScope','$cookieStore','$http', function($scope, BlogService,$location,$rootScope,$cookieStore,$http) {
    $scope.message = 'Look I am on the Blog Page!';
    
    console.log("BlogController...");
    var self = this;
    self.blog = {
    		blogID : '',
    		blogName : '',
    		user_id: '',
    		blogDescription: '',
    		errorCode : '',
			errorMessage : ''
    };
    
    self.blogs = [];
    
    self.listAllBlogs = function(){
    	console.log("listAllBlogs...")
    	BlogService.listAllBlogs()
    		.then(
    				function(d){
    					self.blogs = d;
    				},
    				function(errResponse){
    					console.error('Error while fetching all blogs');
    				}
    		);
    };
    
    self.listAllBlogs();
    
    self.getBlogByID = function(blogID){
    	console.log("getBlogById...")
    	BlogService.getBlogByID(blogID)
    		.then(
    				function(d){
    					self.blog = d;
    					$location.path("/getBlogByID")
    				},
    				function(errResponse){
    					console.error('Error while fetching blog');
    				}
    		);
    };
    
    self.createBlog = function(blog){
    	console.log("createBlog...")
    	BlogService.createBlog(blog)
    		.then(
    				self.listAllBlogs,
    				function(errResponse){
    					console.error('Error while creating blog');
    				}
    		);
    };
    
    self.updateBlog = function(blog,blogID){
    	console.log("updateBlog...")
    	BlogeService.updateBlog(blog,blogID)
    		.then(
    				self.listAllBlogs,
    				function(errResponse){
    					console.error('Error while updating blog');
    				}
    		);
    };
    
    self.deleteBlog = function(blogID){
    	console.log("BlogDelete...")
    	BlogService.deleteBlog(blogID)
    		.then(
    				self.listAllBlogs,
    				function(errResponse){
    					console.error('Error while deleting blog');
    				}
    		);		
    };
    
    self.submit = function(){
    {
    	console.log('Saving New Blog',self.blog);
    	self.createBlog(self.blog);
    	$('submit').click(function(){
    		var status = true;
    		$('.required').each(function(){
    			var element = $(this);
    			var elementVal = $(this).val();
    			var errorMsgId=element.attr('data-errorMsg');
    			if(elementVal==''){
    				$('.'+errorMsgId).show();
    				element.addClass('errorField');
    				status=false;
    			}
    			else{
    				$('.'+errorMsgId).hide();
    				element.removeClass('errorField');
    			}
    		});
    		
    		if(status){
    			$('.alert-success').show();
    		}
    	});
    	}
    	self.reset();
    };
    
    
    
    self.edit = function(blogID){
    	console.log("bolgID to be edited",blogID);
    	for(var i=0;i<self.blogs.length;i++){
    		if(self.blogs[i].blogID === blogID){
    			self.blog = angular.copy(self.blogs[i]);
    			break;
    		}
    	}
    };
    
    self.remove = function(blogID){
    	console.log('blogID to be deleted',blogID);
    	if(self.blog.blogID === blogID){
    		reset();
    	}
    	self.deleteBlog(blogID);
    };
    
    self.reset = function() {
		self.blog = {
			blogID : '',
	    	blogName : '',
	    	user_id: '',
	    	blogDescription: '',
			errorCode : '',
			errorMessage : ''
		};
		$scope.myForm1.$setPristine(); // reset Form
	};
    
}]);
