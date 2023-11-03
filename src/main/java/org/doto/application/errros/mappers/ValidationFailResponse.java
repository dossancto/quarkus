package org.doto.application.errros.mappers;
import java.util.List;

public record ValidationFailResponse(String message, List<String> erros) {
}