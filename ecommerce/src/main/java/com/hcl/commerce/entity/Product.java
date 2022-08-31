package com.hcl.commerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
}
