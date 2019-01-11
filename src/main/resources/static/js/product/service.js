var module = angular.module("productServiceModule",["httpModule"]);
module.service("ProductService",["HttpService",function(HttpService){
	return {
		pager:function(data){
			return HttpService.get("/product?page="+data.page+"&size="+data.size,data);
		},
		save:function(data){
			return HttpService.post("/product",data);
		},
		update:function(data){
			return HttpService.patch("/product",data);
		},
		get:function(id){
			return HttpService.get("/product/"+id);
		}
	}
}]);