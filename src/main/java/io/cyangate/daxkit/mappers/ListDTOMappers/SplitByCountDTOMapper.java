package io.cyangate.daxkit.mappers.ListDTOMappers;

import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.dto.outputdto.ListToSubListsOutputDTO;
import io.cyangate.daxkit.mappers.BaseDTOMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitByCountDTOMapper implements BaseDTOMapper<ListToSubListsInputDTO, ListToSubListsOutputDTO> {
    @Override
    public ListToSubListsOutputDTO convertToDTO(ListToSubListsInputDTO input) {

        List<?> list = input.getList();
        int chunk = input.getChunk();
        int size = list.size();
        int sublistSize = size / chunk;
        int remainder = size % chunk;

        List<List<?>> listOfLists = IntStream.range(0, chunk)
                .mapToObj(i -> {
                    int fromIndex = i * sublistSize + Math.min(i, remainder);
                    int toIndex = fromIndex + sublistSize + (i < remainder ? 1 : 0);
                    return new ArrayList<>(list.subList(fromIndex, toIndex));
                })
                .collect(Collectors.toList());

        return new ListToSubListsOutputDTO(listOfLists);
    }
}

