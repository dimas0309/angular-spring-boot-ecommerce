package com.dagtech.angularspringecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_category")
@Getter
@Setter
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category",
			   fetch=FetchType.EAGER)
	private Set<Product> products;
	
	public void addProducts(Product product) {
		
		if(product != null) {
			
			if (products == null) {
				
				products = new HashSet<>();
			}
			
			product.setCategory(this);
			products.add(product);
		}
	}
	
	

}
