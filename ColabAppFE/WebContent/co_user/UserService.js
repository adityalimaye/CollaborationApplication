/**
 * 
 */
'use strict';

app
		.factory(
				"UserService",
				[
						'$http',
						'$q',
						'$rootScope',
						function($http, $q, $rootScope) {
							console.log('UserService...');
							var BASE_URL = 'http://localhost:8080/CollaborationApplication'

							return {
								listAllUsers : function() {
									console.log("calling listAllUsers ")
									return $http
											.get(BASE_URL + '/users')
											/*	http://localhost:8080/CollaborationApplication/users	*/
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching UserDetails');
														return $q
																.reject(errResponse);
													});
								},

								getUserById : function(user_id) {
									console.log("calling getUserById ")
									return $http
											.get(BASE_URL + '/users/' + user_id)
											/*	http://localhost:8080/CollaborationApplication/users/rah123	*/
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching profile');
														return $q
																.reject(errResponse);
													});
								},

								createUser : function(user) {
									console.log("calling create user")
									return $http
											.post(BASE_URL + '/users/', user)
											/*	http://localhost:8080/CollaborationApplication/users/	*/
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while creating user');
														return $q
																.reject(errResponse);
													});
								},

								updateUser : function(user, user_id) {
									console.log("calling listAllUsers ")
									return $http
											.put(BASE_URL + '/users/', user)
											/*	http://localhost:8080/CollaborationApplication/users/rah123	*/
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while updating user');
														return $q
																.reject(errResponse);
													});
								},

								logout : function() {
									console.log('logout....')
									return $http
											.get(BASE_URL + '/users/logout')
											.then(function(response) {
												return response.data;
											}, null);
								},

								deleteUser : function(user_id) {
									return $http
											.deleteUser(
													BASE_URL + '/users/'
															+ user_id)
											/*	http://localhost:8080/CollaborationApplication/users/sam123	*/
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while deleting the user!');
														return q
																.reject(errResponse);
													});
								},

								authenticate : function(user) {
									console
											.log("Calling the method authenticate with the user :"
													+ user) /*	http://localhost:8080/CollaborationApplication/users/authenticate	*/

									return $http.post(
											BASE_URL + '/users/authenticate/',
											user).then(function(response) {
										return response.data;
									}, null);
								}
							};
						} ]);