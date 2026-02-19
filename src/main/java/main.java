import model.Categoria;
import model.Produto;
import repositorios.CategoriaCollectionRepo;

void main() {
    Categoria categoria = new Categoria();

    // refatorando getters and setters
    categoria.setNome("Informatica");

    Categoria categoriaSalva = CategoriaCollectionRepo.save(categoria);


        IO.println("Categoria: "+ categoria);



}