package com.francomartin.find_your_guide.models;


import com.francomartin.find_your_guide.interfaces.Observer;

public abstract class Trofeo implements Observer {
    protected int id;
    protected String nombre;

    @Override
    public abstract void update(Usuario usuario);
}