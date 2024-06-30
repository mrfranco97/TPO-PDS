package com.francomartin.find_your_guide.models;


public class TrofeoExito extends Trofeo {
    private double minCalificacion;

    public TrofeoExito(int id, String nombre, double minCalificacion) {
        this.id = id;
        this.nombre = nombre;
        this.minCalificacion = minCalificacion;
    }

    @Override
    public void update(Usuario usuario) {
        if (usuario instanceof Guia) {
            System.out.println("Verificando trofeo para guía: " + usuario.getNombre());
            double promedioCalificacion = usuario.getResenias().stream()
                    .mapToDouble(Calificacion::getEstrellas)
                    .average()
                    .orElse(0.0);
            if (promedioCalificacion >= minCalificacion) {
                System.out.println("Trofeo " + nombre + " otorgado al guía " + usuario.getNombre());
                // Aquí puedes agregar la lógica para persistir el trofeo en la base de datos
            } else {
                System.out.println("Trofeo " + nombre + " no otorgado. Promedio actual: " + promedioCalificacion);
            }
        }
    }
}
