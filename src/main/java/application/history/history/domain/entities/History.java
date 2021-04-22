package application.history.history.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "history")
public class History {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column
    private String content;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    public History(String id, String content, LocalDate date) {
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
