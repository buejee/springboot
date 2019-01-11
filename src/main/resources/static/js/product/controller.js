var module = angular.module("productModule",["productServiceModule"]);
module.controller("ProductController",["$scope","ProductService",function($scope,ProductService){
	function getList(){		
		ProductService.pager({page:$scope.page,size:$scope.maxSize}).then(function(data){
			if(data.status==200){
				$scope.list  = $scope.reportData = data.data.rows;
				$scope.total = data.data.total;
			}
		},function(data){
			
		});
	}
	
	$scope.getList = getList;
	$scope.maxSize = 10;
	$scope.total = 0;
	$scope.reportData = [];
	$scope.page = 1;
	getList();
}]);
module.controller("ProductAddController",["$scope","$location","ProductService",function($scope,$location,ProductService){
	$scope.save = function(){
		var data = $scope.product;
		ProductService.save(data).then(function(data){
			if(data.status==200){
				$location.path("/product/list");
			}
		});
	}
}]);
module.controller("ProductUpdateController",["$scope","$stateParams","$location","ProductService",function($scope,$stateParams,$location,ProductService){
	var id = $stateParams.id;
	if(id){
		ProductService.get(id).then(function(data){
			if(data.status==200){
				$scope.product = data.data;
			}
		},function(data){
			console.log("error");
		});
	}
	$scope.save = function(){
		var data = $scope.product;
		//delete data.createDate;
		//delete data.modifyDate;
		ProductService.update(data).then(function(data){
			if(data.status==200){
				$location.path("/product/list");
			}
		});
	}
}]);
module.controller("UploadController",["$scope","ProductService",function($scope,ProductService){
	function uploadProgress(event){
		var ele = document.getElementById("progress");
		if(event.lengthComputable){
			var percent = Math.round(event.loaded*100/event.total);
			ele.innerHTML = percent+"%";
		}else{
			ele.innerHTML = "无法计算";
		}
	}
	function uploadComplete(event){
		alert("上传成功"+event.target.responseText);
	}
	function uploadFailed(event){
		alert("上传失败");
	}
	function uploadCanceled(event){
		alert("上传挂起");
	}
	$scope.save = function(){
		var xhr = new XMLHttpRequest();
		xhr.upload.addEventListener("progress",uploadProgress,false);
		xhr.addEventListener("load",uploadComplete,false);
		xhr.addEventListener("error",uploadFailed,false);
		xhr.addEventListener("abort",uploadCanceled,false);
		xhr.open("POST","/upload/save");
		xhr.send(new FormData(document.getElementById("upload-form")));
	}
}]);