package com.efatura.sistemi.payload;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

	  @NotBlank
	    @Size(min = 4, max = 40)
	    private String name;

	    @NotBlank
	    @Size(min = 3, max = 15)
	    private String username;

	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;

	    @NotBlank
	    @Size(min = 6, max = 20)
	    private String password;

		private String phoneNumber;
		private String customerStatus;
		private String authorityList;
		private Date createdDate;
		private String createdUser;
		
	    public SignUpRequest() {
		
		}
	   
		public SignUpRequest(@NotBlank @Size(min = 4, max = 40) String name,
				@NotBlank @Size(min = 3, max = 15) String username, @NotBlank @Size(max = 40) @Email String email,
				@NotBlank @Size(min = 6, max = 20) String password, String phoneNumber, String customerStatus,
				String authorityList, Date createdDate, String createdUser) {
			this.name = name;
			this.username = username;
			this.email = email;
			this.password = password;
			this.phoneNumber = phoneNumber;
			this.customerStatus = customerStatus;
			this.authorityList = authorityList;
			this.createdDate = createdDate;
			this.createdUser = createdUser;
		}


		public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getCustomerStatus() {
			return customerStatus;
		}

		public void setCustomerStatus(String customerStatus) {
			this.customerStatus = customerStatus;
		}

		public String getAuthorityList() {
			return authorityList;
		}

		public void setAuthorityList(String authorityList) {
			this.authorityList = authorityList;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedUser() {
			return createdUser;
		}

		public void setCreatedUser(String createdUser) {
			this.createdUser = createdUser;
		}
	    
	    
}
