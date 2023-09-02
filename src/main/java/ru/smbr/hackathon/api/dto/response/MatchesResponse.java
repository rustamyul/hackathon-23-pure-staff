package ru.smbr.hackathon.api.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchesResponse<T> {

    private boolean isMatches;

    private T entity;
}
