// package com.ciclo3.saloneventos.entities;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.ToString;

// @Table(name = "admin")
// @Entity
// @Getter @Setter
// @ToString
// public class Administrator {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(nullable = false)
//     private Long id;

//     @Column(name = "email")
//     private String email;

//     @Column(name = "password")
//     private String password;

//     @Column(name = "name")
//     private String name;

//     public Administrator(Long id, String email, String password, String name) {
//         this.id = id;
//         this.email = email;
//         this.password = password;
//         this.name = name;
//     }
// }
