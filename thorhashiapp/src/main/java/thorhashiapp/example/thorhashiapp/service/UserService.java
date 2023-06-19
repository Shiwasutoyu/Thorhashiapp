package thorhashiapp.example.thorhashiapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thorhashiapp.example.thorhashiapp.dto.UserRequest;
import thorhashiapp.example.thorhashiapp.entity.User;
import thorhashiapp.example.thorhashiapp.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // ユーザー情報 全検索
  public List<User> searchAll() {
    return userRepository.findAll();
  }

  // ユーザー情報 id検索
  public User findById(Long id) {
    return userRepository.findById(id).get();
  }

  // ユーザー情報 新規登録
  public void create(UserRequest userRequest) {
    Date now = new Date();
    User user = new User();
    user.setName(userRequest.getName());
    user.setGender(userRequest.getGender());
    // user.setAddress(userRequest.getAddress());
    user.setPhone(userRequest.getPhone());
    user.setComment(userRequest.getComment());
    user.setCreateDate(now);
    user.setUpdateDate(now);
    userRepository.save(user);
  }

  //ユーザー情報 削除
  public void delete(Long id) {
    User user = findById(id);
    userRepository.delete(user);
  }

}
