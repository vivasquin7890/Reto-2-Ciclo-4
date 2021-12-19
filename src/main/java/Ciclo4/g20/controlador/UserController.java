package Ciclo4.g20.controlador;

import Ciclo4.g20.modelo.User;
import Ciclo4.g20.servicio.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Usercontroller en la cual mediante la anotacion @RequestMapping
 * se mapea la clase y se accede a los metodos para crear, actualizar y borrar 
 * los registros mediante los enlaces de url coreespondiente en cada caso
 * @author Victor Vasquez
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    //anotacion sprintboot
    @Autowired
    private UserService userService;

    //listar todos los usuarios
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    //crear usuario
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    //actualizar usuario
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    //borrar usuario por id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }
    
    //validacion de email y passqord
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email, password);
    }
    
    //Validacion del correo
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email){
        return userService.emailExists(email);
    }
       
}
