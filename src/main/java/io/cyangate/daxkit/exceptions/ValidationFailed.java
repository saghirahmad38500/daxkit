package io.cyangate.daxkit.exceptions;

public class ValidationFailed extends RuntimeException{

    public ValidationFailed(String format, Object... args) {
        super(String.format(format, args));
    }

}
