package by.htp.task02.command;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageCommand {
	@RequestMapping("/")
	public String showForm(Model model){
		return "redirect:user/showRegistrationForm";
	}
}
