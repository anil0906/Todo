package build.digital.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import build.digital.dao.TaskDao;
import build.digital.model.Task;

@Repository
public class TaskDaoHibernateImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
        List<Task> taskList = session.createQuery("from Task").list();
        session.close();
        return taskList;
        }

	@Override
	public Task getTask(int id) {
		// TODO Auto-generated method stub
		Task task = null;
		Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Task where taskId = :taskId");
        query.setInteger("taskId", id);
        List<Task> taskList =  query.list();
        if(taskList.size()!=0)
        {
        	task= taskList.get(0);
        	}
        session.close();
        
		
	return task;	
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(task);
		tx.commit();
		session.close();
	}

	@Override
	public void insertTask(Task task) {
		
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(task);
        tx.commit();
        session.close();
	}

	@Override
	public void updateTask(Task task) {

		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(task);
        tx.commit();
        session.close();

		
	}
	
	

}
