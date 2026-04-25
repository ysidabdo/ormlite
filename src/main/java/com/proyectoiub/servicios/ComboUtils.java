package com.proyectoiub.servicios;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilidad única para manejar conversiones a componentes visuales (ComboBox)
 */
public class ComboUtils {



    public static class Item {
        private final int id;
        private final String label;

        public Item(int id, String label) {
            this.id = id;
            this.label = label;
        }

        public int getId() { return id; }
        public String getLabel() { return label; }

        @Override
        public String toString() {
            return label; 
        }
    }

    public static <T> List<Item> map(List<T> entities, String displayField) {
        List<Item> items = new ArrayList<>();
        
        if (entities == null) return items;

        for (T entity : entities) {
            try {
                Field idF = entity.getClass().getDeclaredField("id");
                idF.setAccessible(true);
                int id = (int) idF.get(entity);

                Field labelF = entity.getClass().getDeclaredField(displayField);
                labelF.setAccessible(true);
                String label = String.valueOf(labelF.get(entity));

                items.add(new Item(id, label));

            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.err.println("Error mapeando entidad: " + e.getMessage());
            }
        }
        return items;
    }
}