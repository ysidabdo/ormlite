package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;


@Data
@DatabaseTable
public class Departamento {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String ubicacion;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Empresa empresa;


    public Departamento ActualizarDatos(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        return this;
    }
}