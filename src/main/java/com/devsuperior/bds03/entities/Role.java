package com.devsuperior.bds03.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String authority;

  public Role(Long id, String authority) {
    this.id = id;
    this.authority = authority;
  }

  public Role() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}
