package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;


@Data
@DatabaseTable
public class Proyecto {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String descripcion;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Empresa empresa;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Departamento departamento;


    public Proyecto ActualizarDatos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        return this;
    }
}