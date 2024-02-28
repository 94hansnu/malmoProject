package awsProject.awsProject.database.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slave extends User {
    private String nationality;
    private String name;
    private int age;
    private boolean efficient;
    private boolean obedient;
}