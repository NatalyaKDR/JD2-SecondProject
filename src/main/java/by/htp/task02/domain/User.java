package by.htp.task02.domain;


import java.util.LinkedList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	    private Long id;
	    
	    @NotNull(message=" is required")  //поле обязательно к заполнению
		@Size(min=1, message=" is required")
		private String firstName;
	    
	    private String secondName;
	    
		@NotNull(message="is required")
		@Size(min=1, message=" is required")
		private String login;
		
		@NotNull(message=" is required")
		@Size(min=5, max=15, message="The password must have at least 5 characters (maximum 15)")
		private String password;
		
		private String gender;
		
		private int age;
		
		private String country;
		
		private String[]language;
		
		@NotNull(message=" is required")
		@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message=" incorrect e-mail")
		private String eMail;

	/*	private LinkedList<Integer> ageOptions;
		
		public User() {
			ageOptions = new LinkedList<Integer>();
			for (int i = 1; i < 111; i++) {
				ageOptions.add(i);
			}
	}*/

		
		
		 /*set и get методы для всех полей*/
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getSecondName() {
			return secondName;
		}

		public void setSecondName(String secondName) {
			this.secondName = secondName;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String[] getLanguage() {
			return language;
		}

		public void setLanguage(String[] language) {
			this.language = language;
		}

		public String geteMail() {
			return eMail;
		}

		public void seteMail(String eMail) {
			this.eMail = eMail;
		}

		/*public LinkedList<Integer> getAgeOptions() {
			return ageOptions;
		}*/



			
	}
