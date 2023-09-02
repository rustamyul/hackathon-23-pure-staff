package ru.smbr.hackathon.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Список с пагинацией")
public class PageOfListResponse<T> {

    @Schema(description = "Список")
    private List<T> elements;

    @Schema(description = "Общее кол-во страниц", example = "1")
    @JsonProperty("total_page")
    private int totalPage;

    @Schema(description = "Размер страницы", example = "1")
    private int size;
}
