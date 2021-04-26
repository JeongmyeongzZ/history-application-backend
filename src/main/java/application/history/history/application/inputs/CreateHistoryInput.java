package application.history.history.application.inputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class CreateHistoryInput {
    @NotNull
    private final String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private final LocalDate date;

    public CreateHistoryInput(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }
}
