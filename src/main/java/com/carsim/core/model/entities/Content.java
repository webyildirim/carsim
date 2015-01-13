package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.structure.BaseEntity;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Content extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String extension;
    private String name;
    private String path;
    private int contentType;

    public final static int TYPE_IMAGE = 0;
    public final static int TYPE_TEXT = 1;
    public final static int TYPE_MULTIPART = 2;
    public final static int TYPE_MESSAGE = 3;
    public final static int TYPE_AUDIO = 4;
    public final static int TYPE_VIDEO = 5;
    public final static int TYPE_APPLICATION = 6;


    public Content()
    {
        this.entityName = "Content";
        setContentType(TYPE_IMAGE);
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "NAME")
    public String getName()
    {
        return name;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    @Column(name = "PATH")
    public String getPath()
    {
        return path;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    @Column(name = "EXTENSION")
    public String getExtension()
    {
        return extension;
    }

    public int getContentType() {
		return contentType;
	}

	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	@Override
    public String toString()
    {
        return "" + getId();
    }
}
