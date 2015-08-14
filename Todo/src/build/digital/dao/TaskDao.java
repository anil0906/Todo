package build.digital.dao;

import java.util.List;

import build.digital.model.Task;

public interface TaskDao {

	public List<Task> getAllTask();
	public Task getTask(int id);
	public void deleteTask(Task task);
	public void insertTask(Task task);
	public void updateTask(Task task);
	
}
