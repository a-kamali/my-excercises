package ir.maktab;

public class ApplicationContextImpl {
    private int count = 0;
    private String name;

    public ApplicationContextImpl(String name) {
        if (count < 1){
            this.name = name;
            count++;
        }
    }


    @Override
    public String toString() {
        return "ApplicationContext{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContextImpl context1 = new ApplicationContextImpl("applicationContext.xml");
        ApplicationContextImpl context2 = new ApplicationContextImpl("applicationContext.xml");
        System.out.println(context1.toString());
        System.out.println(context2.toString());
    }
}
