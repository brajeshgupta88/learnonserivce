package com.learnon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import com.learnon.model.entity.enums.Role;
import com.learnon.model.entity.enums.UserStatus;

@Entity
@Table(name = "useraccount", schema = "learnondb", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount extends BaseAuditEntity {

    @Id
  //  @GeneratedValue(generator = "UUID")
  //  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "email", nullable = false, unique = true, length = 180)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "status", length = 50)
    private String status;

   

}
