package build.digital.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import build.digital.dao.TaskDao;
import build.digital.model.Task;
import build.digital.services.TaskManager;

@Service
public class TaskManagerImpl implements TaskManager {

	@Autowired
	private TaskDao taskDao;
	
	
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public List<Task> getAllTasks() {
		
		List<Task> tasks = taskDao.getAllTask();
		return tasks;
	}

	@Override
	public void insertOrUpdateTask(Task task) {
		
taskDao.insertTask(task);
	}
	
	public Task getTask(int id){
		
		return taskDao.getTask(id);
	}

	public void deleteTask(Task task){
		
		taskDao.deleteTask(task);
	}
	public void updateTask(Task task){
		taskDao.updateTask(task);
		
	}
	
}
