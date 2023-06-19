package thorhashiapp.example.thorhashiapp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest implements Serializable {

  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100文字以内で入力してください")
  private String name;

  // @NotEmpty(message = "性別を入力してください")
  private String gender;

  @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
  private String phone;

  private String comment;

  
}
