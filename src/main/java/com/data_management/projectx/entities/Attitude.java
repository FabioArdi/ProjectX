package com.data_management.projectx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("attitude")
public class Attitude extends Lifestyle{

    private String function_group;

    @OneToMany
    @JoinColumn(name = "attitude_id")
    List<Lifestyle> lifestyles;

    public Attitude() {
        super();
    }

    public String getFunction_group() {
        return function_group;
    }

    public void setFunction_group(String function_group) {
        this.function_group = function_group;
    }

    @JsonIgnore
    public List<Lifestyle> getLifestyles() {
        return lifestyles;
    }

    public void setLifestyles(List<Lifestyle> lifestyles) {
        this.lifestyles = lifestyles;
    }
}
