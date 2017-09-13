package by.htp.task02.command;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.task02.domain.User;

@Controller
@RequestMapping("/user")
public class DeleteCommand {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
			.buildSessionFactory();

	@RequestMapping("/deleteUser") 
	public String updateUsers(@RequestParam("id") Long id, Model model) {

		Session session = factory.openSession();

		try {

			session.beginTransaction();

			User user = session.get(User.class, id);

			System.out.println("Del user id = " + user.getId());

			session.delete(user);

			session.getTransaction().commit();

		} finally {
			session.close();
		}

		String message = "User was deleted successfully";
		model.addAttribute("messageDelete", message);
		return "show-list-of-users";
	}
}
