package io.cyangate.daxkit.controllers.listutils;

import io.cyangate.daxkit.controllers.BaseController;
import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.dto.outputdto.ListToSubListsOutputDTO;
import io.cyangate.daxkit.mappers.ListDTOMappers.SplitBySizeDTOMapper;
import io.cyangate.daxkit.validators.ListValidators.ListToSubListsValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/lists", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Lists")
public class ListSplitterBySizeController extends BaseController<ListToSubListsInputDTO, ListToSubListsOutputDTO> {

    public ListSplitterBySizeController() {
        super(new SplitBySizeDTOMapper(), new ListToSubListsValidator());
    }

    @Operation(summary = "Split list into sub lists of given size")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ListToSubListsOutputDTO.class)) })})
    @PostMapping(path = "/split-to-size", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListToSubListsOutputDTO splitListBySize(@Validated @RequestBody ListToSubListsInputDTO listToSubListsDTO) {

       return super.convertToDTO(listToSubListsDTO);

    }

}

