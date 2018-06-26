package mybatis.dbSelect.model;


/**
 * 系统用户实体类，存放系统用户的账户信息
 * @date 2017-06-29 04:24:25
 * @version 1.0
 */

public class User {

	/**
	 * 用户id
	 */
	private String id;

	/**
	 * 登录名（登录系统使用的用户名，不少于6个字符）
	 */
	private String loginName;
 
	/**
	 * 用户名称
	 */
	private String userName;
   
	/**
	 * 登录密码（加盐，用户登录名后3位，md5加密）
	 */
	private String password;

	/**
	 * 电话号码
	 */
	private String mobile;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 权限Id
	 */
	private String positionId;
	
	/**
	 * 注册时间
	 */
	private String enabled;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName="
				+ userName + ", password=" + password + ", mobile=" + mobile
				+ ", email=" + email + ", positionId=" + positionId
				+ ", enabled=" + enabled + "]";
	}
}