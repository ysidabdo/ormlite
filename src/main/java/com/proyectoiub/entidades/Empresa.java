package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;


@Data
@DatabaseTable
public class Empresa {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String sector;

    public Empresa ActualizarDatos(String nombre, String sector) {
        this.nombre = nombre;
        this.sector = sector;
        return this;
    }
}