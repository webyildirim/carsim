package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.structure.BaseEntity;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CONTENTTYPE", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Content")
public class Content extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String extension;
    private String name;
    private String path;
    private String contentType;
    private int type;

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
        setContentType(getEntityName());
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

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    @Column(name = "CONTENTTYPE")
    public String getContentType()
    {
        return contentType;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    @Column(name = "TYPE")
    public int getType()
    {
        return type;
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

    @Override
    public String toString()
    {
        return "" + getId();
    }
}
