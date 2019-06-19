package com.openwebinars.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openwebinars.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	/*Realizar la búsqueda en base al nombre*/
	public List<Student> findByFirstName(String firstName);
	
	/*Realizar la búsqueda en base al apellido*/
	public List<Student> findByLastName(String lastName);
	
	/*Realizar la búsqueda en base al nombre y apellido*/
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	/*Realizar la búsqueda en base al nombre y apellido, y ordenar los resultados descendentemente por apellido*/
    public List<Student> findByFirstNameAndLastNameOrderByLastNameDesc(String firstName, String lastName);
	
    /*
     * CONSULTAS AVANZADAS (ver repo de openwebinars para la busqueda de cadena de caracteres)
     */
    
    /*Realizar las búsquedas en base al id*/
    public Optional<Student> findById(Long id); //No hace falta poner el Query porque ya tenemos el namedQuery en la entidad Student

    /*Actualizar el nombre y apellido*/
    @Modifying
    @Query("update Student s set s.firstName = ?1, s.lastName = ?2 where s.id = ?3")
    int setFirstNameAndLastNameFor(String firstName, String lastName, Long id);
    
}