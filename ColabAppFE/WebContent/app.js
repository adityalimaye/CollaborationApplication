/**
 * 
 */
// create the module and name it scotchApp
        // also include ngRoute for all our routing needs
    var app = angular.module('myCoApp', ['ngRoute','ngCookies'])

    // configure our routes
    app.config(['$routeProvider',function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'home.html',
                controller  : 'mainController'
            })

            .when('/home', {
                templateUrl : 'home.html',
                controller  : 'mainController'
            })
            
            // route for the sign-up page
            .when('/register', {
                templateUrl : 'co_user/register.html',
                controller  : 'UserController'
            })

            // route for the login page
            .when('/login', {
                templateUrl : 'co_user/login.html',
                controller  : 'LoginController'
            })
            
            // route for the login page
            .when('/blog', {
                templateUrl : 'co_blog/blog.html',
                controller  : 'BlogController'
            })
            
            // route for the login page
            .when('/forum', {
                templateUrl : 'co_forum/forum.html',
                controller  : 'ForumController'
            });
    }]);

    // create the controller and inject Angular's $scope
    app.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });
    
 
    
    /*app.run( function ($rootScope, $location,$cookieStore, $http) {

   	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
   		 console.log("$locationChangeStart")
   		 //http://localhost:8080/Collaboration/addjob
   	        // redirect to login page if not logged in and trying to access a restricted page
   	        var restrictedPage = $.inArray($location.path(), ['//','/','/login', '/register']) === -1;
   	        
   	        console.log("restrictedPage:" +restrictedPage)
   	        var loggedIn = $rootScope.currentUser.user_id;
   	        
   	        console.log("loggedIn:" +loggedIn)
   	        
   	        if(!loggedIn)
   	        	{
   	        	
   	        	 if (restrictedPage) {
   		        	  console.log("Navigating to login page:")
   		        	

   						            $location.path('/login');
   		                }
   	        	}
   	        
   			 else //logged in
   	        	{
   	        	
   				 var role = $rootScope.currentUser.role;
   				 var userRestrictedPage = $.inArray($location.path(), ["/post_job"]) == 0;
   				 
   				 if(userRestrictedPage && role!='admin' )
   					 {
   					 
   					  alert("You can not do this operation as you are logged as : " + role )
   					 
   					 }
   				     
   	        	
   	        	}
   	        
   	 }
   	       );
   	 
   	 
   	 // keep user logged in after page refresh
        $rootScope.currentUser = $cookieStore.get('currentUser') || {};
        if ($rootScope.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser; 
        }

   });*/

    

    