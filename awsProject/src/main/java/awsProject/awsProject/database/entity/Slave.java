package awsProject.awsProject.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slave extends User {
    private String nationality;
    private int age;
    private boolean efficient;
    private boolean obedient;

    @ManyToOne
    private Boss boss;
}