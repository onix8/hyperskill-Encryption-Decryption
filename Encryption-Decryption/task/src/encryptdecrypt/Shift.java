package encryptdecrypt;

public class Shift implements Cipher {

    @Override
    public String dec(String data, int key) {
        return enc(data, 26 - (key % 26));
    }

    @Override
    public String enc(String data, int key) {
        String s = "";
        char cc = 0;
        for (char c : data.toCharArray()) {
            if (c != ' ') {
                if (c >= 'a' && c <= 'z') {
                    cc = (char) ('a' + (((c - 'a') + key) % 26));
                } else if (c >= 'A' && c <= 'Z') {
                    cc = (char) ('A' + (((c - 'A') + key) % 26));
                } else {
                    System.out.println("Error: is not latin letter or space.");
                }
            } else {
                cc = c;
            }
            s = s.concat(String.valueOf(cc));
        }
        return s;
    }
}
