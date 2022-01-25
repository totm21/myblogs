package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;


@Controller
public class IndexController {
	@Autowired
	UserService userservice;

	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "admin/index.action", method = RequestMethod.POST)
	public String login(Model model,HttpSession session) {
		return "admin/ulist";
	}
	
	
	@RequestMapping(value = "admin/find.action", method = RequestMethod.POST)
	public String find(Model model,HttpSession session) {
		
		return "admin/ulist";
	}

}
