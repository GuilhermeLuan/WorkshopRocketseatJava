package br.com.dosk.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired //Spring vai gerenciar da forma que ele achar melhor, instanciar
    private IUserRepository userRepository;

    // @RequestBody -> A informação vai vim dentro do body
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existe!");
            return null;
        }

        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
