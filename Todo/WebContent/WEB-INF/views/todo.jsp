<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Anil Sharma">

<link rel="shortcut icon" href="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
<title>Todo</title>
</head>
<body ng-app="todo" ng-controller="todoController" class="container">


	<input type="text" class="form-control" id="task"
		placeholder="Enter ToDo Task"
		ng-keydown="$event.which === 13 && saveText()">

	<div>
		<ul class="list-group">
			<li ng-repeat="task in tasks| orderBy : 'task.taskId'	: reverse"
				class="list-group-item">
				<div class=row>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"> <input type="checkbox"
								aria-label="" ng-checked="task.taskStatus=='COMPLETED'"
								ng-click="changeStatus(task)">
							</span> <input type="text" class="form-control" aria-label=""
								value={{task.taskDescription}} id={{task.taskId}}
								ng-keydown="$event.which === 13 && updateText(task)"> <span
								class="glyphicon glyphicon-remove input-group-addon"
								aria-hidden="true" ng-click="deleteText(task)"></span>
						</div>

					</div>
			</li>
		</ul>

	</div>

	<script src="res/js/jquery.js"></script>
	<script src="res/js/angular.min.js"></script>
	<script src="res/js/todo.js"></script>

</body>
</html>