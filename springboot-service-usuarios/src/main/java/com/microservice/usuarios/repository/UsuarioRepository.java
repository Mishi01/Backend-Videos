package com.microservice.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservice.commons.users.entity.Usuario;
@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

	//select u from Usuario u where u.username = ?1
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("username")String username);
	
	//select u from Usuario u where u.username = ?1 and u.email = ?2
	public Usuario findByUsernameAndEmail(@Param("username")String username, @Param("email")String email);

	@Query(value = "select u from Usuario u where u.username = ?1")
	public Usuario obtenerPorUsername(@Param("username")String username);
	
	@Query(value = "select u from Usuario u where u.username = ?1 and u.email = ?2")
	public Usuario obtenerPorUsernameYEmail(@Param("username")String username, @Param("email")String email);
}
