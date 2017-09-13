package by.htp.task02.command;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.task02.domain.User;

@Controller
@RequestMapping("/user")
public class LoginationProcessCommand {
	
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
			.buildSessionFactory(); // запрашиваем файл конфигурации и строим фабрику
	
	
	@InitBinder // чтобы пробелы не воспринимались как значение
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Value("#{countryOptions}") // обращаюсь к полю в контексте spring
	private Map<String, String> countryOptions;
	
	@Value("#{ageOptions}") // обращаюсь к полю в контексте spring
	private Map<Integer, Integer> ageOptions;
	

	@RequestMapping("/showRegistrationForm")
	public String showForm(Model theModel) {
		User user = new User();
		theModel.addAttribute("User", user);
		theModel.addAttribute("theCountryOptions", countryOptions);
		theModel.addAttribute("theAgeOptions", ageOptions);
		return "show-user-form";
	}

	@RequestMapping(value = "/processForm", method = RequestMethod.POST) //срабатывает после нажатия submit
	public String processForm(@Valid @ModelAttribute("User") User user, BindingResult bindingResult, Model theModel) {
		
		System.out.println("data: " + user.getLogin() + " " + user.getPassword() + " " + user.getCountry() + " "
				+ user.getAge() + " " + user.getGender());
		System.out.println(" bindingResult" +  bindingResult);
	
		
		
		if (bindingResult.hasErrors()) {
		
			theModel.addAttribute("theCountryOptions", countryOptions); //чтобы при повторной попытке рег-ии подгрузились страны
			theModel.addAttribute("theAgeOptions", ageOptions);
			return "show-user-form";
		}
	
		Session session = factory.openSession();

		try {
			session.beginTransaction();

			System.out.println("Saving the user...");
			session.save(user);

			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			session.close();
			// factory.close();
		}

		return "new-user-page";
	}

}


