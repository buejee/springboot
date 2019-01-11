/**
 * 
 */
var directModule = angular.module("directModule",[]);
/*
directModule.directive("hello",[function(){
	return {
		restrict:'E',
		template:'<div>hello,world</div>',
		replace:true
	};
}]);*/
directModule.directive("hello",[function(){
	return {
		restrict:'E',
		templateUrl:"hello.html",
		scope:{
			name:'='
		},
		replace:true
	};
}]);