package com.centime.hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parent_id")
    private Person parent;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    @JsonIgnore
    private String color;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)//Avoiding empty json arrays.objects
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Person> subClasses;

}