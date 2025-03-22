package io.cyangate.daxkit.validators;

import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;

import java.util.List;

public interface Validator<I extends BaseInputDTO> {

    void validate(I input);
    public default void validate(List<I> list){}

}
