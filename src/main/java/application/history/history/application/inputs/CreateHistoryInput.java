package application.history.history.application.inputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateHistoryInput {
    private final String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final Date date;

    public CreateHistoryInput(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    public Date getDate() {
        return this.date;
    }

    public String getContent() {
        return content;
    }
}
