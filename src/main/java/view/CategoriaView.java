package view;

import model.Categoria;
import repositorios.CategoriaCollectionRepo;

import javax.swing.*;

public class CategoriaView {
    static CategoriaCollectionRepo repo;


    public static Categoria select(Categoria categoria) {
        // @formatter: off

        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma Categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repo.findAll().toArray(),
                categoria == null ? 1 : categoria
        );
        return ret;
        // formatter: on
    }
    public void sucesso(){
        JOptionPane.showMessageDialog(null,"Categoria Salva com sucesso!");
    }

    public void sucesso(Categoria categoria){
        JOptionPane.showMessageDialog(null,"Categoria " +categoria.getNome()+ " Salva com sucesso!");
    }
    public static Categoria form(Categoria categoria){
        String nome = JOptionPane.showInputDialog(null,
                "Informe o nome da categoria",categoria !=null ? categoria.getNome() : "");
        return new Categoria(nome);
    }

}
