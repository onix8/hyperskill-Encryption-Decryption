package encryptdecrypt;

import java.io.*;

public class InputData implements Crypt {

    private String data = "";
    private int key = 0;
    private String mode = "enc";
    private String alg = "shift";
    private String in = "";
    private String out = "";

    private boolean dataIsOn;
    private boolean keyIsOn;
    private boolean modeIsOn;
    private boolean algIsOn;
    private boolean inIsOn;
    private boolean outIsOn;

    void output() {

        // If there are both "-data" and "-in" arguments, prefer "-data" over "-in".
        if (dataIsOn) {
            inIsOn = false;
        }

        if (!inIsOn && !outIsOn) {
            writeInToOut(data);
        }

        if (inIsOn && outIsOn) {
            writeFileToFile(in, out);
        }

        if (!inIsOn && outIsOn) {
            writeInToFile(data, out);
        }

        if (inIsOn && !outIsOn) {
            writeFileToOut(in);
        }
    }

    private void writeFileToFile(String fileIn, String fileOut) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            while (reader.ready()) {
                writer.write(cipher(reader.readLine(), alg, key, mode));
            }
        } catch (IOException e) {
            System.out.println("Error: value of the \"-in\" argument: \"" + fileIn + "\". Value of the \"-out\" argument: \"" + fileOut);
        }
    }

    private void writeFileToOut(String fileIn) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn))) {
            while (reader.ready()) {
                System.out.println(cipher(reader.readLine(), alg, key, mode));
            }
        } catch (IOException e) {
            System.out.println("Error: value of the \"-in\" argument: \"" + fileIn + "\".");
        }
    }

    private void writeInToFile(String dataIn, String fileOut) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            writer.write(cipher(dataIn, alg, key, mode));
        } catch (IOException e) {
            System.out.println("Error: value of the \"-out\" argument: \"" + fileOut);
        }
    }

    private void writeInToOut(String dataIn) {
        System.out.println(cipher(dataIn, alg, key, mode));
    }

    // Setters and Getters
    public boolean isDataIsOn() {
        return dataIsOn;
    }

    public boolean isInIsOn() {
        return inIsOn;
    }

    public void setInIsOn(boolean inIsOn) {
        this.inIsOn = inIsOn;
    }

    public boolean isOutIsOn() {
        return outIsOn;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        this.dataIsOn = true;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
        this.keyIsOn = true;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
        this.modeIsOn = true;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
        this.algIsOn = true;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
        this.inIsOn = true;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
        this.outIsOn = true;
    }
}
