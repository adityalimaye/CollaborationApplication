/**
 * 
 */
'use strict';

app
		.controller(
				'UserController',
				[
						'$scope',
						'UserService',
						'$location',
						'$rootScope',
						'$cookieStore',
						'$http',
						function($scope, UserService, $location,
								$rootScope, $cookieStore, $http) {
							$scope.message = 'Look! I am on registration page.';

							console.log("UserController...");
							var self = this;
							self.user = {
								user_id : '',
								user_name : '',
								password : '',
								contact_num : '',
								user_address : '',
								email_id : '',
								is_online : '',
								user_role : '',
								errorCode : '',
								errorMessage : ''

							};

							self.users = [];

							self.listAllUsers = function() {
								console.log("listAllUsers...")
								UserService
										.listAllUsers()
										.then(
												function(d) {
													self.users = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Users');
												});
							};

							//self.listAllUsers();
							self.createUser = function(user) {
								console.log("createUser...")
								UserService
										.createUser(user)
										.then(
												self.listAllUsers,
												function(errResponse) {
													console
															.error('Error while creating User.');
												});
							};

							self.getUserById = function(user_id) {
								console.log("getUserById...")
								UserService
										.getUserById(user_id)
										.then(
												function(d) {
													self.user = d;
													$location
															.path("/getUserById")
												},
												function(errResponse) {
													console
															.error('Error while fetch profile.');
												});
							};

							self.updateUser = function(user, user_id) {
								console.log("updateUser...")
								UserService
										.updateUser(user, user_id)
										.then(
												self.listAllUsers,
												function(errResponse) {
													console
															.error('Error while updating User.');
												});
							};

							self.authenticate = function(user) {
								console.log("authenticate...")
								UserService
										.authenticate(user)
										.then(
												function(d) {
													self.user = d;
													console
															.log("user.errorCode: "
																	+ self.user.errorCode)
													if (self.user.errorCode == "404") {
														alert(self.user.errorMessage)
														self.user.id = "";
														self.user.password = "";
													} else {
														console
																.log("Valid credentials. Navigating to home page")
														$rootScope.currentUser = self.user
														$http.defaults.headers.common['Authorization'] = 'Basic '
																+ $rootScope.currentUser;
														$cookieStore
																.put(
																		'currentUser',
																		$rootScope.currentUser);
														$location.path('/');
													}
												},
												function(errResponse) {
													console
															.error('Error while authenticate Users');
												});
							};

							self.logout = function() {
								console.log("logout")
								$rootScope.currentUser = {};
								$cookieStore.remove('currentUser');
								UserService.logout()
								$location.path('/');

							}

							self.deleteUser = function(user_id) {
								console.log("UserController...")
								UserService
										.deleteUser(user_id)
										.then(
												self.listAllUsers,
												function(errResponse) {
													console
															.error('Error while deleting User.');
												});
							};

							self.login = function() {
								{
									console.log('login validation????????',
											self.user);
									self.authenticate(self.user);
								}

							};

							self.submit = function() {
								{
									console.log('Saving New User', self.user);
									self.createUser(self.user);
								}
								self.reset();
							};

							self.reset = function() {
								self.user = {
									user_id : '',
									user_name : '',
									password : '',
									contact_num : '',
									user_address : '',
									email_id : '',
									is_online : '',
									user_role : '',
									errorCode : '',
									errorMessage : ''
								};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);