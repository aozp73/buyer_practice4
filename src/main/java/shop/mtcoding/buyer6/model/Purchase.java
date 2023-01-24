package shop.mtcoding.buyer6.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {
    private int id;
    private int userId;
    private int productId;
    private int count;
    private Timestamp createdAt;
}
