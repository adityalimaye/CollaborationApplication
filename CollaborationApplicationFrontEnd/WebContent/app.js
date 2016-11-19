/**
 * 
 */

    // create the module and name it scotchApp
    var myColabApp = angular.module('myColabApp', ['ngRoute']);
    
    //configure our routes
    myColabApp.config(function($routeProvider){
    	$routeProvider
    	
    	//route for the home page
    	.when('/',{
    		templateUrl : 'home.html',
    		controller : 'mainController'	
    	})
    	
    	.when('/home',{
    		templateUrl : 'home.html',
    		controller : 'mainController'	
    	})
    });
    
    

    // create the controller and inject Angular's $scope
    myColabApp.controller('mainController', function($scope) {

        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });

/*
var myColabApp = angular.module('myColabApp',['ngRoute']);

myColabApp.controller('mainController',function($scope){
	$scope.message = 'My First Angular Project!';
});
*/