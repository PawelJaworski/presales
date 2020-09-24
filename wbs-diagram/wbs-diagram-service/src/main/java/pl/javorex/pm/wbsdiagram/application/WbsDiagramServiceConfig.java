package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbsdiagram.application.api.WbsDiagramCommandFacade;
import pl.javorex.pm.wbsdiagram.application.api.WbsDiagramQueryFacade;
import pl.javorex.pm.wbsdiagram.domain.repository.WbsDiagramRepository;

public final class WbsDiagramServiceConfig {
    public final WbsDiagramQueryFacade wbsDiagramQueryFacade;
    public final WbsDiagramCommandFacade wbsDiagramCommandFacade;

    public WbsDiagramServiceConfig(WbsDiagramRepository projectRepository) {
        this.wbsDiagramQueryFacade = new WbsDiagramQueryFacadeImpl(projectRepository);
        this.wbsDiagramCommandFacade = new WbsDiagramCommandFacadeImpl(projectRepository);
    }
}
