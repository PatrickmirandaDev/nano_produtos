package repositorios;

import model.Categoria;
import model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors; // Necessário para filtrar listas

public class ProdutoCollectionRepo {
    private static List<Produto> produtos = new Vector<>();

    static {
        // Inicialização de dados de teste
        Produto smartphone = new Produto();
        smartphone.setId(1L); // Definindo ID inicial
        smartphone.setNome("google pixel 9")
                .setDescricao("smartphone android google")
                .setCategoria(CategoriaCollectionRepo.findById(2L))
                .setDataCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(3500));

        produtos.add(smartphone);
    }

    public static List<Produto> findAll() {
        return produtos;
    }

    public static Produto save(Produto produto) {
        if (!produtos.contains(produto)) {
            // Gera ID baseado no tamanho atual se for um novo produto
            if (produto.getId() == null) {
                produto.setId((long) produtos.size() + 1);
            }
            produtos.add(produto);
            return produto;
        } else {
            JOptionPane.showMessageDialog(null, "Já existe um produto cadastrado com o mesmo nome");
            return null;
        }
    }

    public static Produto findById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId() != null && p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // CORREÇÃO: Agora retorna uma lista filtrada corretamente
    public static List<Produto> findByCategoria(Categoria categoria) {
        if (categoria == null) return new Vector<>();

        return produtos.stream()
                .filter(p -> p.getCategoria() != null && p.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }
}