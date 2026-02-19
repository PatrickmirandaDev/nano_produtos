import model.Categoria;
import model.Produto;
import repositorios.CategoriaCollectionRepo;
import repositorios.ProdutoCollectionRepo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

void main() {
    // 1. Busca a categoria correta (Eletronicos)
    List<Categoria> listaGeral = CategoriaCollectionRepo.findByNome("Eletronicos");

    // Verificação de segurança para evitar o erro de "Index 0 out of bounds"
    if (listaGeral.isEmpty()) {
        System.out.println("Erro: A categoria 'Eletronicos' não foi encontrada no repositório.");
        return;
    }

    Produto produto = new Produto();
    produto.setNome("google pixel 9")
            .setDescricao("smartphone")
            // 2. Pegamos a categoria da lista validada
            .setCategoria(listaGeral.get(0))
            .setDataCadastro(LocalDateTime.now())
            .setPreco(BigDecimal.valueOf(800));

    // 3. Salvamos o produto
    Produto produtoSalva = ProdutoCollectionRepo.save(produto);

    // 4. Verificamos se o produtoSalva não é nulo antes de imprimir
    if (produtoSalva != null) {
        System.out.println("ID: " + produtoSalva.getId() + " | Nome do produto: " + produtoSalva.getNome());
    } else {
        System.out.println("Erro ao salvar: Produto provavelmente já existe.");
    }
}