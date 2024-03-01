package awsProject.awsProject.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boss extends BaseEntity {
  //  @ManyToOne
   // private User user;

    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Slave> slaves;
}
