import model.Categoria;
import model.Produto;
import repositorios.CategoriaCollectionRepo;
import repositorios.ProdutoCollectionRepo;
import view.CategoriaView;
import view.Opcao;
import view.OpcaoView;
import view.ProdutoView;

import javax.swing.*;

void main() {
    Opcao opcao = null;

    do {
        opcao = OpcaoView.select();
        switch (opcao) {
            case CADASTRAR_CATEGORIA -> cadastrarCategoria();

            case CADASTRAR_PRODUTO -> cadastrarProduto();

            case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoId();

            case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoCategoria();

            case ALTERAR_PRODUTO -> alterarProduto();

            case ENCERRAR_SISTEMA -> encerrarSistema();

        }
    }while (opcao != Opcao.ENCERRAR_SISTEMA);
}

private void encerrarSistema() {
    IO.println("Encerrando Sistema...");
    System.exit(0);
}

private void alterarProduto() {
    Produto produto = ProdutoView.select(null);
    ProdutoView.update(produto);
}

private void consultarProdutoCategoria() {
    Categoria categoria = CategoriaView.select(null);
    List<Produto> produtos = ProdutoCollectionRepo.findByCategoria(categoria);

    // CORREÇÃO: Verifica se a lista NÃO está vazia para exibir
    if (produtos != null && !produtos.isEmpty()) {
        produtos.forEach(ProdutoView::show);
    } else {
        JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
    }
}

private void consultarProdutoId() {
    Long id = -1L;
    do {
        try {
            id = Long.parseLong(JOptionPane.showInputDialog("Informe o id do produto:"));
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao tentar ler o id do produto!");
        }
    }while(id <= 0);

    Produto produto = ProdutoCollectionRepo.findById(id);
    if (produto != null) {
        ProdutoView.show(produto);
    }else {
        JOptionPane.showMessageDialog(null,"Produto Nao Encontrado!");
    }
}

private void cadastrarProduto() {
    Produto produto = ProdutoView.form(new Produto());
    ProdutoCollectionRepo.save(produto);
    ProdutoView.sucesso();


}

private void cadastrarCategoria() {
    CategoriaView view = new CategoriaView();
    Categoria categoria = view.form(new Categoria());
    CategoriaCollectionRepo.save(categoria);
    view.sucesso(categoria);
}



