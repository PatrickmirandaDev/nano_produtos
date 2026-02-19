package repositorios;

import model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

import static repositorios.CategoriaCollectionRepo.save;

public class ProdutoCollectionRepo {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<> ();

        Produto smartphone = new Produto();
        smartphone.setNome("google pixel 9")
                .setDescricao("smartphone android google")
                .setCategoria((CategoriaCollectionRepo.findById(2L)))
                .setDataCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(3500));

    save(smartphone);

    }
    public static Produto save(Produto produto){
        if(!produtos.contains(produto)) {
            produto.setId((long) produtos.size()+1);
            produtos.add(produto);
            return produto;
        }else {
            JOptionPane.showMessageDialog(null,"Ja existe um produto cadastrado com o mesmo nome");
            return null;
        }
    }
}
