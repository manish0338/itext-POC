var app = angular.module("app");

app.controller("mainController",function($scope,$http){
	console.log("in ctrl");
	
	$scope.submit = function(){
		var data = document.body.innerHTML;
		$http.post("/createPDF",{html:data});
	};
});