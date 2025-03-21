package io.cyangate.daxkit.mappers;

import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;
import io.cyangate.daxkit.dto.outputdto.BaseOutputDTO;

public interface BaseDTOMapper<I extends BaseInputDTO, O extends BaseOutputDTO> {

    O convertToDTO(I input);

}
