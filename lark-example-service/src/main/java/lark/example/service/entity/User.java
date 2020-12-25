package lark.example.service.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Andy Yuan on 2020/11/3.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private int sex;
    private String name;
}
