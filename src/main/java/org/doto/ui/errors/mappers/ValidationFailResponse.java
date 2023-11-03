package org.doto.ui.errors.mappers;

import java.util.List;

public record ValidationFailResponse(String message, List<String> erros) {
}