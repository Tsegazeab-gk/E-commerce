package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.ReviewStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="buyer_id")
	private Buyer buyer ;

	@ManyToOne
	@JoinColumn(name="product_id")
	 private Product product ;

	@NotBlank(message = "comment can't empty!")
	private String comment ;


	@Enumerated(EnumType.STRING)
	private ReviewStatus reviewStatus = ReviewStatus.Created;

	@Column(name = "comment_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime commentTime = LocalDateTime.now();

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", comment='" + comment + '\'' +
				'}';
	}
}
