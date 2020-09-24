package pl.javorex.pm.wbsdiagram.application.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TaskPresentationDto {
    long getId();
    String getName();
    List<String> getCategories();
    Optional<BigDecimal> getEstimation();
    List<TaskPresentationDto> getChildren();
}
