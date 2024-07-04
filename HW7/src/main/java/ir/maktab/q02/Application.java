package ir.maktab.q02;

public class Application {
    public static void main(String[] args) {
        char[] chars1 = {'h','e','l','l','o'};
        char[] chars2 = {' ','w','o','r','l','d'};
        Sequence word1 = new Sequence();
        word1.setValue(chars1);

        Sequence word2 = new Sequence();
        word2.setValue(chars2);

        int indexOfE = word1.indexof('e');
        System.out.println(indexOfE);

        word1.concat(word2);
        System.out.println(word1);

        Sequence word3 = new Sequence();
        word3.setValue(chars2);

        System.out.println(word1.equals(word2));
        System.out.println(word2.equals(word3));


    }

}
