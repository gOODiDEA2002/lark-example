import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    private long order_id;
    private long user_id;
    private int sku_id;
}
