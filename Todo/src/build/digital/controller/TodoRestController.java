package build.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import build.digital.model.Task;
import build.digital.services.TaskManager;

@Controller
@RequestMapping(value="task")
public class TodoRestController {

	@Autowired
	TaskManager taskManager;
	
	public void setTaskManager(TaskManager taskManager) {
		this.taskManager = taskManager;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		System.out.println("before task created :" +task.getTaskId());
		taskManager.insertOrUpdateTask(task);
	
		System.out.println("task created :" +task.getTaskId());
		HttpHeaders headers = new HttpHeaders();
	
		//String location = linkTo()
		//headers.setLocation(linkTo(TodoRestController.class).slash(task.getTaskId()).toUri);
		return new ResponseEntity<Task>(task,headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{taskId}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Task> getTask(@PathVariable Integer taskId){
		
		System.out.println("task id is : "+taskId);
		Task task = taskManager.getTask(taskId);
		System.out.println("task : "+task);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{taskId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId){
			
			System.out.println("task id is : "+taskId);
			Task task = taskManager.getTask(taskId);
			 taskManager.deleteTask(task);
			System.out.println("task : "+task);
			HttpHeaders headers = new HttpHeaders();

			return new ResponseEntity<Void>(headers,HttpStatus.OK);
		}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{taskId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId,@RequestBody Task task){
			
			System.out.println("task id is : "+taskId);
			//Task task = taskManager.getTask(taskId);
			 taskManager.updateTask(task);
			System.out.println("updated task : "+task);
			HttpHeaders headers = new HttpHeaders();

			return new ResponseEntity<Void>(headers,HttpStatus.OK);
		}
	
	@RequestMapping(method=RequestMethod.GET,value="",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Task>> getTasks(){
		
		//System.out.println("task id is : "+taskId);
		List<Task> task = taskManager.getAllTasks();
		System.out.println("task : "+task);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Task>>(task,HttpStatus.OK);
	}
}
