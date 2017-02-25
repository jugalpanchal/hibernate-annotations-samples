package com.jugalpanchal.db.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "caption")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "caption_type", discriminatorType = DiscriminatorType.STRING)
public class Caption extends PersistentEntity {

	@Column(name = "value", columnDefinition="TEXT")
	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Caption()
	{
		super();
	}
	
	/*public Caption(Date creationDate,Long creationUserId, String value)
	{
		super(creationDate,creationUserId);
		this.value = value;
	}*/

	public String getValue() {
		return value;
	}
}