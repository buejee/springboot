var httpModule = angular.module("httpModule",[]);
httpModule.factory("HttpService",["$http","$q",function($http,$q){
	function execute(type,url,data){
		var d = $q.defer();
		var config = {};
		if(data)config.data = data;
		config.method = type;
		config.url = url;
		if(type=="POST"||type=="PATCH"){
			config.headers = {"Content-Type":"application/x-www-form-urlencoded"};
			config.transformRequest = function(obj){
				var str = [];
				for(var p in obj){
					str.push(encodeURIComponent(p) +"="+encodeURIComponent(obj[p]));				
				}
				return str.join("&");
			}
		}
		var promise = $http(config);
		promise.then(function(success){
			d.resolve(success);
		},function(error){
			d.reject(error);
		});
		return d.promise;
	}
	var service = {
		post:function(url,data){
			return execute("POST",url,data);
		},
		get:function(url,data){
			return execute("GET",url,data);
		},
		put:function(url,data){
			return execute("PUT",url,data);
		},
		patch:function(url,data){
			return execute("PATCH",url,data);
		},
		deleteOne:function(url,data){
			return execute("DELELE",url,data);
		}
	};
	return service;
}]);