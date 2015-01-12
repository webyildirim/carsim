package com.carsim.core.model.entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "ServiceContent")
@DiscriminatorValue("ServiceContent")
@PrimaryKeyJoinColumn(name = "CONTENTID", referencedColumnName = "ID")
public class ServiceContent extends Content
{
    private boolean defaultContent;

    public ServiceContent()
    {
        this.entityName = "ServiceContent";
        setContentType(getEntityName());
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

    @Override
    public String toString()
    {
        return "" + getId();
    }
}
