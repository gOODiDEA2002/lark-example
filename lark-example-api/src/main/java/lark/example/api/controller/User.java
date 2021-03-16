package lark.example.api.controller;

import lark.db.jsd.NameStyle;
import lark.db.jsd.annotation.JsdTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andy Yuan on 2020/11/3.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsdTable(nameStyle = NameStyle.LOWER)
public class User {
    @Id
    private int id;
    private int sex;
    private String name;
}
