package entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="whatever")
public class Class { // <- nie nazywajcie tak klas w waszych projektach :)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Class(String name) {
        this.name = name;
    }
}

