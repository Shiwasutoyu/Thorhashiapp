package thorhashiapp.example.thorhashiapp.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "gender")
  private String gender;

  @Column(name = "phone")
  private String phone;

  @Column(name = "comment")
  private String comment;

  @Column(name = "update_date")
  private Date updateDate;

  @Column(name = "create_date")
  private Date createDate;

  @Column(name = "delete_date")
  private Date deleteDate;

}
