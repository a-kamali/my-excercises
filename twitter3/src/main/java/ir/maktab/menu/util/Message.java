package ir.maktab.menu.util;

public class Message {

    public static final String inputMessage = "Please Enter %s";
    public static final String existMessage = "%s is already exist";
    public static final String sucessfulMessage = "%s Successful";
    public static final String failedMessage = "%s Failed";
    public static final String invalidInputMessage = "%s is Invalid Input";



    public String getInputMessage(String input) {
        return String.format(inputMessage,input);
    }

    public String getExistMessage(String input){
        return String.format(existMessage,input);
    }

    public String getSucessfulMessage(String input){
        return String.format(sucessfulMessage,input);
    }

    public String getFailedMessage(String input){
        return String.format(failedMessage,input);
    }

    public String getInvalidInputMessage(String input){
        return String.format(invalidInputMessage,input);
    }

}
