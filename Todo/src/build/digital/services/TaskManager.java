package build.digital.services;

import java.util.List;

import build.digital.model.Task;

public interface TaskManager {

	public List<Task> getAllTasks();
	public void insertOrUpdateTask(Task task);
	public Task getTask(int id);
	public void deleteTask(Task task);
	public void updateTask(Task task);
	
}
