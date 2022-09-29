package com.hcl.commerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "stock_count")
	private int stockCount;

	@Column(name = "date_created")
	private LocalDate dateCreated;

	@Column(name = "date_last_updated")
	private LocalDate dateLastUpdated;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;	

	@Column(name = "image_url")
	private String image_url;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
	
	@OneToMany
	@JoinColumn(name="product_id")
	private List<Rating> ratings = new ArrayList<>();
	
	@Column(name = "avgrating")
	private Double avgrating;
	
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}
	
	public void deleteRating(Rating rating) {
		this.ratings.remove(rating);
	}
	
	public void updateAverageRating() {
		Double avg = (double) 5;
		int totalRating = 0;
		int ratingCount = 0;
		for( Rating rating : ratings) {
			totalRating += rating.getRating();
			ratingCount++;
		}
		if(ratingCount == 0) {
			ratingCount = 1;
		}
		avg = (double) (totalRating/ratingCount);
		if(avg == 0) {
			avg = (double) 5;
		}
		this.avgrating = avg;
	}
}
