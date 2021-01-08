package lark.example.api.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {

    private int id;

    private String name;

    private String mobile;
}
