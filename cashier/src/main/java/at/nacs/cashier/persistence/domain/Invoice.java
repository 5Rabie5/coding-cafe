package at.nacs.cashier.persistence.domain;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Invoice {

  @Id
  @GeneratedValue
  private long id;

  private String uuid;
  private LocalDateTime timestamp;

  @ElementCollection
  private List<String> orders = new ArrayList<>();
  private Double total;
}
