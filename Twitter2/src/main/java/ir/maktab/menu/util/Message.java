package ir.maktab.menu.util;

public class Message {

    private  final String successfulMessage = "%s is successful";
    private  final String unsuccessfulMessage = "%s is unsuccessful";
    private  final String failedMessage = "%s is failed";
    private final String enterInformation = "Please Enter %s";

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public String getUnsuccessfulMessage() {
        return unsuccessfulMessage;
    }

    public String getFailedMessage() {
        return failedMessage;
    }

    public String getEnterInformation() {
        return enterInformation;
    }
}
