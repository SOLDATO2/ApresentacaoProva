package principal.daos;

import java.util.List;

public interface DAO<T> {

	T buscarPorId(Integer id);	
	List<T> listar();
	T salvar(T entidade);
	T atualizar(T entidade);
	void excluir(Integer id);	

}
