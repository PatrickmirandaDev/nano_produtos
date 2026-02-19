package repositorios;

import model.Categoria;


import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepo {
    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();

        Categoria eletronicos = new Categoria("Eletronicos");
        Categoria eletrodomestico = new Categoria("Eletrodomestico");
        Categoria literatura = new Categoria("Literatura");
        Categoria Ereader = new Categoria("E-reader");


        save(new Categoria("Eletronicos"));
        save(new Categoria("Eletrodomestico"));
        save(new Categoria("Literatura"));
        save(new Categoria("E-reader"));
    }

    // metodos acessores
        public static List<Categoria> findAll() {
            return categorias;
        }
// consulta pelo ID // !=null garante que nao quebre o programa caso nao encotre o id
        public static Categoria findById(Long id) {
            return categorias.stream()
                    .filter(c -> c.getId() !=null && c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }
// consulta pelo nome
        public static List<Categoria> findByNome(String nome) {
            return categorias.stream()
                    .filter(c->c.getNome()
                            .equalsIgnoreCase(nome)).toList();

        }
    // salva a categoria
        public static Categoria save(Categoria categoria) {
            if (!categorias.contains(categoria)) {
                categoria.setId((long)categorias.size() +1);
                categorias.add(categoria);
                return categoria;
            }else {
                JOptionPane.showMessageDialog(null,
                        "Ja existe uma categoria com o nome informado.");
                return null;
            }
        }

    }


