package io.cyangate.daxkit.validators;

import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;

public interface Validator<I extends BaseInputDTO> {

    void validate(I input);

}
