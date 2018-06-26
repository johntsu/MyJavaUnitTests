package mybatis.resultSet.model;

public class Author {
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String bio;
	
	private String favouriteSection;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the favouriteSection
	 */
	public String getFavouriteSection() {
		return favouriteSection;
	}

	/**
	 * @param favouriteSection the favouriteSection to set
	 */
	public void setFavouriteSection(String favouriteSection) {
		this.favouriteSection = favouriteSection;
	}

}
