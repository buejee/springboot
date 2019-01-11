/**
 * 
 */
var userModule = angular.module("userModule",["userServiceModule","ui.bootstrap"]);
userModule.controller("UserController",["$scope","$location","$uibModal","UserService",function($scope,$location,$uibModal,UserService){
	/*
	UserService.query(function(success){
		console.log(success);
	},function(error){
		console.log(error);
	});*/
	$scope.name = "angular";
	$scope.items = [ 'angularjs', 'backbone', 'canjs', 'Ember', 'react' ];
	// open click
	$scope.open = function(size) {
		var modalInstance = $uibModal.open({
			templateUrl : 'dialog.html',
			controller : 'ModalInstanceCtrl', // specify controller for modal
			size : size,
			resolve : {
				items : function() {
					return $scope.items;
				}
			}
		});
		// modal return result
		modalInstance.result.then(function(selectedItem) {
			$scope.selected = selectedItem;
		}, function() {
			console.log('Modal dismissed at: ' + new Date())
		});
	}
}]).controller('ModalInstanceCtrl', function($scope, $uibModalInstance, items) {
	
	$scope.items = items;
	
	$scope.selected = {
		item : $scope.items[0]
	};
	// ok click
	$scope.ok = function() {
		$uibModalInstance.close($scope.selected.item);
	};
	// cancel click
	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	}
});
userModule.controller("LoginController",["$scope","$location","UserService",function($scope,$location,UserService){
	//用户登录接口
	$scope.login = function(){
		UserService.login($scope.user).then(function(data){
			if(data.status==200&&data.data.status=="success"){
				$location.path("/admin/list");
			}
		},function(data){
			
		});
	}
	$scope.user={username:"admin",password:"123456"};
}]);