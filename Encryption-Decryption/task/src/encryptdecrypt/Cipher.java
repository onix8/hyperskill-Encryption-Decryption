package encryptdecrypt;

interface Cipher {

    String dec(String data, int key);

    String enc(String data, int key);
}
