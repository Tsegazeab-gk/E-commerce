package com.super4tech.ecommerce.domain;


import com.super4tech.ecommerce.validation.PasswordMatches;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@PasswordMatches
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Size(min = 3, message = "{password}")
	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private int active;

	@Transient
	@Size(min =3, message = "{password}")
	private String matchingPassword;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;


}
