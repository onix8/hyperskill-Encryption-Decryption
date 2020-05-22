package encryptdecrypt;

import java.util.Set;

public interface ArgumentNames {
    String ARGUMENT_NAME_MODE = "-mode";
    String ARGUMENT_NAME_ALG = "-alg";
    String ARGUMENT_NAME_KEY = "-key";
    String ARGUMENT_NAME_DATA = "-data";
    String ARGUMENT_NAME_IN = "-in";
    String ARGUMENT_NAME_OUT = "-out";
    Set<String> ARGUMENT_NAMES =
            Set.of(ARGUMENT_NAME_MODE, ARGUMENT_NAME_KEY, ARGUMENT_NAME_DATA, ARGUMENT_NAME_IN, ARGUMENT_NAME_OUT, ARGUMENT_NAME_ALG);
}
