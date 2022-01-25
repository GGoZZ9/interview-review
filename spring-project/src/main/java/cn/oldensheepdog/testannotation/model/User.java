package cn.oldensheepdog.testannotation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = -7544679692598308407L;

    private String name;
    private Integer age;

}
