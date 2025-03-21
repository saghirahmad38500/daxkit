package io.cyangate.daxkit.mappers.ListDTOMappers;

import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.dto.outputdto.ListToSubListsOutputDTO;
import io.cyangate.daxkit.mappers.BaseDTOMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListToSubListsDTOMapper implements BaseDTOMapper<ListToSubListsInputDTO, ListToSubListsOutputDTO> {
    @Override
    public ListToSubListsOutputDTO convertToDTO(ListToSubListsInputDTO input) {

        List<?> list = input.getList();
        int chunkSize = input.getChunk() <= 0 ? list.size() : input.getChunk();

        List<List<?>> listOfLists = IntStream.range(0, (list.size() + chunkSize - 1) / chunkSize)
                .mapToObj(i -> list.subList(i * chunkSize, Math.min((i + 1) * chunkSize, list.size())))
                .collect(Collectors.toList());

        return new ListToSubListsOutputDTO(listOfLists);

    }

}

