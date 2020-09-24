package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbsdiagram.application.api.WbsDiagramQueryFacade;
import pl.javorex.pm.wbsdiagram.application.response.WbsDiagramPresentationDto;
import pl.javorex.pm.wbsdiagram.domain.repository.WbsDiagramRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

final class WbsDiagramQueryFacadeImpl implements WbsDiagramQueryFacade {
    private final WbsDiagramPresentationDtoFactory projectInfoDtoMapper = new WbsDiagramPresentationDtoFactory();
    private final WbsDiagramRepository projectRepository;

    public WbsDiagramQueryFacadeImpl(WbsDiagramRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<WbsDiagramPresentationDto> findDiagramByProjectId(String projectId) {
        return projectRepository.findWbsDiagramByID(projectId)
                .map(projectInfoDtoMapper::fromProject);
    }

    @Override
    public List<WbsDiagramPresentationDto> findAll() {
        return projectRepository.findAll().stream()
                .map(projectInfoDtoMapper::fromProject)
                .collect(Collectors.toList());
    }
}
