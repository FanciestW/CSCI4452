package me.williamlin.mylayoutapplication;

/**
 * Created by william on 2/9/18.
 */

public class State {
    public String name, population, country_sized;
    int rep_size;

    State(String name, String population, String country_sized, int rep_size){
        this.name = name;
        this.population = population;
        this.country_sized = country_sized;
        this.rep_size = rep_size;
    }
}
