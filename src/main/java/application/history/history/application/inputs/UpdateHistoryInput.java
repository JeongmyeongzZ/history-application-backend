package application.history.history.application.inputs;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public final class UpdateHistoryInput {
    @NotNull
    private String content;
}
