package com.carsim.core.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ServiceContent extends Content
{
	@ManyToOne
	private Service service;
    private boolean defaultContent;

    public ServiceContent()
    {
        this.entityName = "ServiceContent";
    }

    public void setDefaultContent(boolean defaultContent)
    {
        this.defaultContent = defaultContent;
    }

    @Column(name = "DEFAULTCONTENT")
    public boolean isDefaultContent()
    {
        return defaultContent;
    }

    public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
    public String toString()
    {
        return "" + getId();
    }
}
