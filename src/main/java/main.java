import model.Categoria;
import model.Produto;

void main() {
    Categoria categoria = new Categoria();

    // refatorando getters and setters
    categoria.setId(1L).setNome("Eletronicos");


    Produto produto = new Produto();
    produto.setId(1L)
            .setNome("Kindle")
            .setDescricao("E-reader")
            .setCategoria(categoria)
            .setDataCadastro(LocalDateTime.now()).setPreco(BigDecimal.valueOf(800));

        IO.println("Categoria: "+ categoria);
        IO.println("Nome: "+ produto);


}