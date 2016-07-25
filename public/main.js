var app = angular.module("app",["ngRoute"]);

app.config(function($routeProvider,$locationProvider){
	$routeProvider
		.when("/",{
			controller: "mainController",
			templateUrl: "assets/template/form.html"
		});
	$locationProvider.html5Mode(true);
});