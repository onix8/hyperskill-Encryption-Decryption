package encryptdecrypt;

public class Unicode implements Cipher {

    @Override
    public String dec(String data, int key) {
        String s = "";
        for (char c : data.toCharArray()) {
            s = s.concat(String.valueOf((char) (c - key)));
        }
        return s;
    }

    @Override
    public String enc(String data, int key) {
        String s = "";
        for (char c : data.toCharArray()) {
            s = s.concat(String.valueOf((char) (c + key)));
        }
        return s;
    }
}
