package io.cyangate.daxkit.controllers.listutils;

import io.cyangate.daxkit.controllers.BaseController;
import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.dto.outputdto.ListToSubListsOutputDTO;
import io.cyangate.daxkit.mappers.ListDTOMappers.ListToSubListsDTOMapper;
import io.cyangate.daxkit.validators.ListValidators.ListToSubListsValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/lists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListToSubListsControllerController extends BaseController<ListToSubListsInputDTO, ListToSubListsOutputDTO> {

    public ListToSubListsControllerController() {
        super(new ListToSubListsDTOMapper(), new ListToSubListsValidator());
    }

    @Operation(summary = "Split list into sub list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ListToSubListsOutputDTO.class)) })})
    @PostMapping(path = "/split-to-sub-lists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListToSubListsOutputDTO splitListIntoSubLists(@Validated @RequestBody ListToSubListsInputDTO listToSubListsDTO) {

       return super.convertToDTO(listToSubListsDTO);

    }

}

