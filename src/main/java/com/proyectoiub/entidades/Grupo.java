package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;


@Data
@DatabaseTable
public class Grupo {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String categoria;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Departamento departamento;


    public Grupo ActualizarDatos(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        return this;
    }
}