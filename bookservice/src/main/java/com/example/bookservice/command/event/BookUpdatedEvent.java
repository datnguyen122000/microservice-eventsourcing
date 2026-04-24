package com.example.bookservice.command.event;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdatedEvent {
    @Id
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
