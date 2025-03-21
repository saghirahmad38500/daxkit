package io.cyangate.daxkit.validators.ListValidators;

import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.exceptions.ValidationFailed;
import io.cyangate.daxkit.validators.Validator;

public class ListToSubListsValidator implements Validator<ListToSubListsInputDTO> {
    @Override
    public void validate(ListToSubListsInputDTO input) {

        if(input.getList() == null) throw new ValidationFailed("List can not be null");

        if(input.getChunk() < 0) throw new ValidationFailed("Chunk size can not be less than 0");

    }
}
