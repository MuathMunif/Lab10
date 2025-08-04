package seu.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seu.lab10.Model.UserModel;
import seu.lab10.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserModel userModel) {
        userRepository.save(userModel);
    }
    public boolean deleteUser(Integer id) {
        UserModel userModel = userRepository.getById(id);
        if (userModel == null) {
            return false;
        }
        userRepository.delete(userModel);
        return true;
    }

    public boolean updateUser(Integer id ,UserModel userModel) {
        UserModel oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setName(userModel.getName());
        oldUser.setAge(userModel.getAge());
        oldUser.setEmail(userModel.getEmail());
        oldUser.setRole(userModel.getRole());
        oldUser.setPassword(userModel.getPassword());
        userRepository.save(oldUser);
        return true;
    }

}
