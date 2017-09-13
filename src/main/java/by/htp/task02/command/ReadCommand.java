package by.htp.task02.command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.task02.domain.User;

@Controller
@RequestMapping("/user")
public class ReadCommand {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@Value("#{ageOptions}")
	private Map<Integer, Integer> ageOptions;
	
	
	
	
	@RequestMapping("/readUsers")
	public String showAllUsers(Model model){
		Session session = factory.openSession();
		try {
			System.out.println("Greating new user object...");
		
			session.beginTransaction();
			
			@SuppressWarnings({ "unchecked", "unused" })
			List<User> allUsers = session.createQuery("FROM User").list(); 
			
			
			session.getTransaction().commit();
			System.out.println("------Name" + allUsers.get(0).getFirstName());
			
		
		model.addAttribute("users",allUsers);
			
		} finally {
			session.close();
			//factory.close();
		}
		return "show-list-of-users";
	}
}