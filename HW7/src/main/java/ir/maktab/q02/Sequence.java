package ir.maktab.q02;

public class Sequence {
    private char[] value;

    public Sequence() {
    }

    public void setValue(char[] value) {
        this.value = value;
    }

    public char[] getValue() {
        return value;
    }

    public void concat(Sequence sequence) {
        char[] result = new char[value.length + sequence.value.length];
        for (int i = 0; i < this.value.length; i++) {
            result[i] = this.value[i];
        }
        for (int i = 0; i < sequence.value.length; i++) {
            result[i + value.length] = sequence.value[i];
        }
        this.value = result;
    }

    public int indexof(char character) {
        int result = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == character) {
                result = i;
                break;
            }
        }
        return result;
    }

    public char[] replace(Sequence oldChars, Sequence newChars) {
        int counter = 0;
        char[] result;
        for (int i = 0; i < oldChars.getValue().length; i++) {
            if(value[i] == oldChars.getValue()[i]){
                counter++;
            }
        }
        if(counter == oldChars.getValue().length){
          result =  newChars.getValue();
        }else {
            result = this.value;
        }
        return result;
    }

    public boolean equals(Sequence otherSeq) {
        int counter = 0;
        for (int i = 0; i < otherSeq.value.length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                if (otherSeq.value[i] == this.value[j]) {
                    counter++;
                }
            }

        }
        if(counter == otherSeq.getValue().length){
            return true;
        }else {
            return false;
        }
    }

}

