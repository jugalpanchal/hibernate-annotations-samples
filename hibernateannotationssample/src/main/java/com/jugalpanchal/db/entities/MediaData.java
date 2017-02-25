package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "media_data")
public class MediaData extends PersistentEntity {
	
	@Column(name = "generic_blob", columnDefinition = "longblob")
	private byte[] genericBlob;

	@Column(name = "media_type")
	private String type;

	@Column(name = "media_extension")
	private String extension;

	public MediaData() {
		super();
	}

	public MediaData(User createdByUser, Date creationDate, byte[] genericBlob, String type, String extension) {
		super(createdByUser, creationDate);
		this.type = type;
		this.extension = extension;
		this.genericBlob = genericBlob;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getGenericBlob() {
		return genericBlob;
	}

	public void setGenericBlob(byte[] genericBlob) {
		this.genericBlob = genericBlob;
	}
}
