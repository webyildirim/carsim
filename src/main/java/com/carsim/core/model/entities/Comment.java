package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.structure.BaseEntity;

@Entity
public class Comment extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private boolean ratedPoor;
    private boolean ratedAverage;
    private boolean ratedGood;
    private boolean ratedExcellent;
    private String detail;

    public Comment()
    {
        entityName = "Comment";
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

    @Override
    public String toString()
    {
        return ""+getId();
    }
}
