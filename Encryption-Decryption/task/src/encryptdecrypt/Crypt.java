package encryptdecrypt;

public interface Crypt {
    default String cipher(String data, String alg, int key, String mode) {

        Cipher cipher;

        switch (alg) {
            case "unicode":
                cipher = new Unicode();
                break;
            case "shift":
                cipher = new Shift();
                break;
            default:
                System.out.println("Error: value of the \"-alg\" argument must be \"unicode\" or \"shift\". Value of the \"-alg\" argument: \"" + alg + "\". Dale will use the default value (\"shift\").");
                cipher = new Shift();
        }

        switch (mode) {
            case "dec":
                return cipher.dec(data, key);
            case "enc":
                return cipher.enc(data, key);
            default:
                System.out.println("Error: value of the \"-mode\" argument must be \"dec\" or \"enc\". Value of the \"-mode\" argument: \"" + mode + "\". Dale will use the default value (\"enc\").");
                return cipher.enc(data, key);
        }
    }
}
