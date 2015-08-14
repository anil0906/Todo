package build.digital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import build.digital.model.Task;
import build.digital.services.TaskManager;

@Controller

public class todoUIController {

	@Autowired
	TaskManager taskManager;
	
	public void setTaskManager(TaskManager taskManager) {
		this.taskManager = taskManager;
	}


	@RequestMapping(value={"/","/todo**"},method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView();
	
		model.setViewName("todo");
		return model;
	}
}
