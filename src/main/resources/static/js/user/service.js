/**
 * 
 */
var userServiceModule = angular.module("userServiceModule",["ngResource","httpModule"]);
/*
userServiceModule.service("UserService",["$resource",function($resource){
	return $resource('/api/user/:id',
			{id:'@id'},
			{change:{method:'POST',params:{change:true},isArray:false}})
}]);*/
userServiceModule.service("UserService",["HttpService",function(HttpService){
	return {
		login:function(data){
			return HttpService.post("/user/login",data);
		}
	}
}]);