package application.history.history.application.inputs;

import java.text.SimpleDateFormat;

public class CreateHistoryInput {
    private final String content;
    private final String date;

    public CreateHistoryInput(String date, String content) {
        this.date = date;
        this.content = content;
    }

//    public getDate() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(this.date);
//    }

    public String getContent() {
        return content;
    }
}
