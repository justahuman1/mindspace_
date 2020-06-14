package com.saivalla.mindspace.models;

import com.saivalla.mindspace.models.customTypes.PGEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;

@Entity
@Table(name = "question_category")
@TypeDef(
    name = "pg_enum",
    typeClass = PGEnumType.class
)
public class QCategory {
    @Id
    public short id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "The representative category of the enumerated ID")
    @Type(type = "pg_enum")
    public CategoryEnum type;

    // TODO: Add getters/setters -> change final to String
}
