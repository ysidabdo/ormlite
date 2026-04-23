package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;


@Data
@DatabaseTable
public class Organizacion {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String tipo;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Empresa empresa;

    public Organizacion ActualizarDatos(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        return this;
    }
}