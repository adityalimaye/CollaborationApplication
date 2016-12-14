/**
 * 
 */
'use strict';
app.factory("BlogService",['$http','$q','$rootScope',function($http,$q,$rootScope){
	console.log('BlogService...')
	var BASE_URL = 'http://localhost:8080/CollaborationApplication'
	return{
		listAllBlogs : function(){
			console.log("calling listAllBlogs ")
			return $http.get(BASE_URL + '/listAllBlogs')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching blog list');
						return $q.reject(errResponse);
					}
			);
		},
		
		getBlogById : function(blogID){
			console.log("calling getBlogById")
			return $http.get(BASE_URL + '/getBlogById' + blogID)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching blog by id');
						return $q.reject(errResponse);
					}
			);
		},
		
		createBlog : function(blog) {
			console.log("calling createBlog")
			return $http.post(BASE_URL + '/createBlog/', blog)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while creating blog');
						return $q.reject(errResponse);
					}
				);
		},
		
		updateBlog : function(blog, blogID) {
			console.log("calling updateBlog ")
			return $http.put(BASE_URL + '/updateBlog/'+ blogID)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while updating blog');
						return $q.reject(errResponse);
					}
				);
		},
		
		deleteBlog : function(blogID) {
			return $http.deleteBlog(BASE_URL + '/deleteBlog/'+ blogID)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while deleting blog!');
						return q.reject(errResponse);
					}
				);
		},
	}	
}]);