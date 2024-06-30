package com.francomartin.find_your_guide.models;

public class TrofeoResenia extends Trofeo {
    private int cantReseñas;

    public TrofeoResenia(int id, String nombre, int cantReseñas) {
        this.id = id;
        this.nombre = nombre;
        this.cantReseñas = cantReseñas;
    }

    @Override
    public void update(Usuario usuario) {
        if (usuario instanceof Turista) {
            System.out.println("Verificando trofeo para turista: " + usuario.getNombre());
            if (usuario.getResenias().size() >= cantReseñas) {
                System.out.println("Trofeo " + nombre + " otorgado al turista " + usuario.getNombre());
                // Aquí puedes agregar la lógica para persistir el trofeo en la base de datos
            } else {
                System.out.println("Trofeo " + nombre + " no otorgado. Reseñas actuales: " + usuario.getResenias().size());
            }
        }
    }
}
