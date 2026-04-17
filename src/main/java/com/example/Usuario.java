package com.example;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;

@Data
@DatabaseTable
public class Usuario {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String email;

    public Usuario Actualizardatos(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        return this;
    }


}