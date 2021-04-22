package application.history.history.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    public History(String id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public String getDateByFormat(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(this.date);
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
