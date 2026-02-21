import model.Categoria;
import model.Produto;
import repositorios.CategoriaCollectionRepo;
import repositorios.ProdutoCollectionRepo;
import view.CategoriaView;
import view.Opcao;
import view.OpcaoView;
import view.ProdutoView;

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
}

private void consultarProdutoId() {
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



