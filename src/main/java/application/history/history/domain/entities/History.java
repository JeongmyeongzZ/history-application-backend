package application.history.history.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "histories")
public class History {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column
    private String content;

    @Temporal(TemporalType.DATE)
    private Date date;

    public History(String id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }
}
