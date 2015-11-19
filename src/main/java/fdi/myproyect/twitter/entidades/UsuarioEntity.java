package fdi.myproyect.twitter.entidades;

public class UsuarioEntity {

	String username;
	String password;
	String email;
	Boolean login;
	
	public UsuarioEntity(){
		
	}
	
	public UsuarioEntity(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}
	
	
	
}
