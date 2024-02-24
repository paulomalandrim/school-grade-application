package br.malandrim.schoolgradeapplication.dto;

import java.util.List;

public record RegisterDTO(String name, String username, String password, List<String> roles) {
}
