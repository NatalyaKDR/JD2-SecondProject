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
public class UpdateCommand {
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
	
	
		
	@RequestMapping("/updateUsers")
	public String updateUsers(@RequestParam("id") Long id, Model model){
		Session session = factory.openSession();
		
		try {
			User user = new User();
			
			session.beginTransaction();
			
			user = session.get(User.class, id);
			
			System.out.println("------" + user.getId());
			
			session.getTransaction().commit();
			model.addAttribute("User",user);
			model.addAttribute("theCountryOptions", countryOptions);
		} finally {
			session.close();
			
		}
		return "update-user-page";
	}

	
	@RequestMapping("/processFormUpdate")
	public String processFormUpdate(@RequestParam("id") Long id, @Valid @ModelAttribute("User") User user, BindingResult bindingResult, Model model, HttpServletRequest request) {

		Session session = factory.openSession();
	
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("theCountryOptions", countryOptions);
			return "update-user-page";
		}
		//Long id = (long) Integer.parseInt(request.getParameter("id"));

		
		
			try {
				session.beginTransaction();
				
				System.out.println("Saving the user update... id = " + request.getParameter("id"));
		
				user = session.get(User.class, id);
				user.setFirstName(request.getParameter("firstName"));
				user.setSecondName(request.getParameter("secondName"));
				user.seteMail(request.getParameter("eMail"));
				user.setLogin(request.getParameter("login"));
				user.setPassword(request.getParameter("password"));
				user.setCountry(request.getParameter("country"));
				//user.setAge(Integer.parseInt(request.getParameter("age")));
				user.setGender(request.getParameter("gender"));
				
				
				session.getTransaction().commit();
				System.out.println("Done!!!");
			} finally {
				session.close();
				//factory.close();
			}
			String message = "Data was changed successfuly";
			model.addAttribute("message", message);
			return "show-list-of-users";
		}
	
}
