var todo = angular.module("todo", []);

todo.factory("getTasksFactory", function($http) {
	return {
		saveTask : function(data,methodType,url) {
			
			console.log("data : " + data+methodType);
			var reqParam = {
				method : methodType,
				url : url,
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},
				data : data

			}

			var task = {};
			$http(reqParam).success(function(resp) {
				console.log(resp);
				angular.copy(resp, task);
			});
			return task;
		},
		
		getTasks : function() {
			   var reqParam = {
				method : 'GET',
				url : 'task',
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},

			}

			var tasks = [];

			$http(reqParam).success(function(resp) {
				console.log();
				angular.copy(resp, tasks);
			});
			return tasks;
		}
	};
});

todo.controller("todoController", function($scope, getTasksFactory) {

	
	$scope.tasks = getTasksFactory.getTasks();
	$scope.saveText = function() {
		var data = {};
		data.taskDescription = $("#task").val();
		data.taskStatus = "ACTIVE";
		console.log(data);
		$("#task").val('');
		var task = getTasksFactory.saveTask(data,'POST','task');
		$scope.tasks.push(task);
	}

	$scope.updateText = function(task) {
		var data = task;
			
		data.taskDescription = $('#'+task.taskId).val();
		
		var task = getTasksFactory.saveTask(data,'PUT','task/'+task.taskId);
		
	
	}
	
	$scope.deleteText = function(task) {
		var data = task;
			
		var task = getTasksFactory.saveTask(data,'DELETE','task/'+task.taskId);
		
		$scope.tasks.pop(task);
	
	}
	
	$scope.changeStatus = function(task) {
		var data = task;
		
		if(task.taskStatus=='COMPLETED')
		task.taskStatus='ACTIVE';
		else
			task.taskStatus='COMPLETED';
			
		var task = getTasksFactory.saveTask(data,'PUT','task/'+task.taskId);
		
		
	
	}
	
	
});


