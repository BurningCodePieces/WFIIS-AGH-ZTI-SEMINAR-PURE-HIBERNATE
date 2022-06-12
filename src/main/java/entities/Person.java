package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class"))
    private Class aClass;

    public Person(String name, String email, Class aClass) {
        this.name = name;
        this.email = email;
        this.aClass = aClass;
    }
}
