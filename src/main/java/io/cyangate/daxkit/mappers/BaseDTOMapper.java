package io.cyangate.daxkit.mappers;

import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;
import io.cyangate.daxkit.dto.outputdto.BaseOutputDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseDTOMapper<I extends BaseInputDTO, O extends BaseOutputDTO> {

    O convertToDTO(I input);

    default O convertListToDTO(List<I> list){throw new IllegalArgumentException("Method Implementation Needed");}

}
