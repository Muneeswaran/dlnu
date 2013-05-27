package com.myitbbs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CategoryChild {
	public int id;
	public String name;
	public String describle;
	private Category category;

	@Id
	@OneToMany(cascade={CascadeType.ALL})
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryChild_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="categoryChild_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="categoryChild_describle")
	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}

	@ManyToOne()
	@JoinColumn(name = "categoryChild_category_Id",nullable = false, referencedColumnName = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		System.out.println("!!!!!!");
		this.category = category;
	}
}
