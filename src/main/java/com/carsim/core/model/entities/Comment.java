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
@DiscriminatorColumn(name = "COMMENTTYPE", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Comment")
public class Comment extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private boolean ratedPoor;
    private boolean ratedAverage;
    private boolean ratedGood;
    private boolean ratedExcellent;
    private String detail;
    private String commentType;

    public Comment()
    {
        entityName = "Comment";
        setCommentType(this.getEntityName());
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "RATEDAVERAGE")
    public boolean isRatedAverage()
    {
        return ratedAverage;
    }

    public void setRatedAverage(boolean ratedAverage)
    {
        this.ratedAverage = ratedAverage;
    }

    @Column(name = "RATEDEXCELLENT")
    public boolean isRatedExcellent()
    {
        return ratedExcellent;
    }

    public void setRatedExcellent(boolean ratedExcellent)
    {
        this.ratedExcellent = ratedExcellent;
    }

    @Column(name = "RATEDGOOD")
    public boolean isRatedGood()
    {
        return ratedGood;
    }

    public void setRatedGood(boolean ratedGood)
    {
        this.ratedGood = ratedGood;
    }

    @Column(name = "RATEDPOOR")
    public boolean isRatedPoor()
    {
        return ratedPoor;
    }

    public void setRatedPoor(boolean ratedPoor)
    {
        this.ratedPoor = ratedPoor;
    }

    @Column(name = "DETAIL", length = 500)
    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public void setCommentType(String commentType)
    {
        this.commentType = commentType;
    }

    @Column(name = "COMMENTTYPE", length = 30)
    public String getCommentType()
    {
        return commentType;
    }

    @Override
    public String toString()
    {
        return getCommentType() + " - " + getId();
    }
}
