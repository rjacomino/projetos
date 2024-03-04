package tutorial.tuto_reste_api.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.tuto_reste_api.model.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Integer> {


}
