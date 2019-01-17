package info.rothem.sales.salesbackend.repository;

import org.springframework.data.repository.CrudRepository;

import info.rothem.sales.salesbackend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}