package encryptdecrypt;

public class Main implements ArgumentNames {

    public static void main(String[] args) {

        //Container for all input data.
        InputData inputData = new InputData();

        // Parsing arguments.
        for (int i = 0, argsLength = args.length - 1; i < argsLength; i++) {
            setValueArgumentToInputData(inputData, args[i], args[i + 1]);
        }

        inputData.output();
    }

    private static void setValueArgumentToInputData(InputData inputData, String argumentName, String argumentValue) {

        if (ARGUMENT_NAMES.contains(argumentName) && ARGUMENT_NAMES.contains(argumentValue)) {
            System.out.println("Error: argument \"" + argumentName + "\" doesn't have a value. Dale will use the default value.");
        }

        if (ARGUMENT_NAMES.contains(argumentValue)) {
            return;
        }

        switch (argumentName) {
            case ARGUMENT_NAME_DATA:
                inputData.setData(argumentValue);
                break;
            case ARGUMENT_NAME_KEY:
                try {
                    inputData.setKey(Integer.parseInt(argumentValue));
                } catch (NumberFormatException e) {
                    System.out.println("Error: value of the \"-key\" argument must be a number. Value of the \"-key\" argument: \"" + argumentValue + "\". Dale will use the default value.");
                }
                break;
            case ARGUMENT_NAME_MODE:
                inputData.setMode(argumentValue);
                break;
            case ARGUMENT_NAME_ALG:
                inputData.setAlg(argumentValue);
                break;
            case ARGUMENT_NAME_IN:
                inputData.setIn(argumentValue);
                break;
            case ARGUMENT_NAME_OUT:
                inputData.setOut(argumentValue);
        }
    }
}
