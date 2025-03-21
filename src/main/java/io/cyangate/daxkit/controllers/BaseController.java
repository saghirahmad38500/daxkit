package io.cyangate.daxkit.controllers;

import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;
import io.cyangate.daxkit.dto.outputdto.BaseOutputDTO;
import io.cyangate.daxkit.exceptions.ValidationFailed;
import io.cyangate.daxkit.mappers.BaseDTOMapper;
import io.cyangate.daxkit.validators.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
public class BaseController<I extends BaseInputDTO, O extends BaseOutputDTO> {

    private final BaseDTOMapper<I, O> baseDTOMapper;
    private final Validator<I> validator;

    protected O convertToDTO(I inputDTO) {
        try {
            validator.validate(inputDTO);
            return baseDTOMapper.convertToDTO(inputDTO);
        }
        catch (ValidationFailed e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
