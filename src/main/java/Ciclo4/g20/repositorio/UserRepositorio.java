package Ciclo4.g20.repositorio;

import Ciclo4.g20.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Ciclo4.g20.repositorio.crud.UserCrudRepositorio;

/**
 *
 * @author 
 */
@Repository
public class UserRepositorio {
    @Autowired
    private UserCrudRepositorio userCrudRepositorio;

    public List<User> getAll() {
        return (List<User>) userCrudRepositorio.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepositorio.findById(id);
    }

    public User save(User user) {
        return userCrudRepositorio.save(user);
    }

    public void update(User user) {
        userCrudRepositorio.save(user);
    }
    
    public void delete(User user){
        userCrudRepositorio.delete(user);
    }
    
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepositorio.findByEmail(email);
        return usuario.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepositorio.findByEmailAndPassword(email, password);
    }
}