package repositorios;

import model.Categoria;


import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepo {
    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();

        Categoria eletronicos = new Categoria("Eletronicos");
        Categoria  eletrodomestico = new Categoria("Eletrodomestico");
        Categoria literatura = new Categoria("Literatura");

        categorias.add(eletronicos);
        categorias.add(eletrodomestico);
        categorias.add(literatura);

        public static List<Categoria> findAll() {
            return categorias;
        }

        public static Categoria findById(Long id) {
            return categorias.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

    }

}
