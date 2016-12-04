/**
 * 
 */
// create the module and name it scotchApp
        // also include ngRoute for all our routing needs
    var myCoApp = angular.module('myCoApp', ['ngRoute'])

    // configure our routes
    myCoApp.config(['$routeProvider',function($routeProvider) {
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
            
            // route for the about page
            .when('/register', {
                templateUrl : 'co_user/register.html',
                controller  : 'RegisterController'
            })

            // route for the contact page
            .when('/login', {
                templateUrl : 'co_user/login.html',
                controller  : 'LoginController'
            });
    }]);

    // create the controller and inject Angular's $scope
    myCoApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });

    

    