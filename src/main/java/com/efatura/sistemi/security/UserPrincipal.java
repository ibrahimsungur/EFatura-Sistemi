package com.efatura.sistemi.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.efatura.sistemi.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;
	
	private String authorityList;
	private String phoneNumber;
	private String customerStatus;
	private Date createdDate;
	private String createdUser;

	private Collection<? extends GrantedAuthority> authorities;
	
	

	public UserPrincipal(Long id, String name, String username, String email, String password, String authorityList,
			String phoneNumber, String customerStatus, Date createdDate, String createdUser,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorityList = authorityList;
		this.phoneNumber = phoneNumber;
		this.customerStatus = customerStatus;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.authorities = authorities;
	}
	
	public static UserPrincipal create(User user) {
		List<GrantedAuthority>authorities=user.getRoles().stream().map(role->
		new SimpleGrantedAuthority(role.getName().name()))
		.collect(Collectors.toList());
		
		  return new UserPrincipal(
	                user.getId(),
	                user.getName(),
	                user.getUsername(),
	                user.getEmail(),
	                user.getPassword(),
	                user.getAuthorityList(),
	                user.getCustomerStatus(),
	                user.getCreatedUser(),
	                user.getCreatedDate(),
	                user.getPhoneNumber(),
	                authorities
	        );
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAuthorityList() {
		return authorityList;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
