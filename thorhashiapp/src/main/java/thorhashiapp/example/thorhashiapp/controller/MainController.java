package thorhashiapp.example.thorhashiapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import thorhashiapp.example.thorhashiapp.dto.UserRequest;
import thorhashiapp.example.thorhashiapp.entity.User;
import thorhashiapp.example.thorhashiapp.service.UserService;

@Controller
public class MainController {

  @Autowired
  private UserService userService;

  // ユーザー情報一覧画面の表示
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<User> userList = userService.searchAll();
    model.addAttribute("userList", userList);
    return "user/list";
  }

  // ユーザー新規登録画面の表示
  @GetMapping(value = "/user/add")
  public String displayAdd(Model model) {
    model.addAttribute("userRequest", new UserRequest());
    return "user/add";
  }

  // ユーザー新規登録処理
  @RequestMapping(value = "/user/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "user/add";
    }
    // ユーザー情報の登録
    userService.create(userRequest);
    return "redirect:/user/list";
  }

  //ユーザー情報の削除
  @GetMapping("/user/{id}/delete")
  public String delete(@PathVariable Long id, Model model) {
    // ユーザー情報の削除
    userService.delete(id);
    return "redirect:/user/list";
  }

  // ユーザー情報詳細画面を表示
  @GetMapping("/user/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    User user = userService.findById(id);
    model.addAttribute("userData", user);
    return "user/view";
  }


  // -----テスト-----

  // @RequestMapping(value = "/test", method = RequestMethod.GET)
  // public String showTest(Model model) {
  //   model.addAttribute("title", "Test Success!");
  //   model.addAttribute("message", "テストは成功しました。");
  //   return "test";
  // }

  
  //ホーム画面
  //会員マイページ    管理者画面
  //投稿一覧画面      会員一覧画面
  // |
  // 

}
