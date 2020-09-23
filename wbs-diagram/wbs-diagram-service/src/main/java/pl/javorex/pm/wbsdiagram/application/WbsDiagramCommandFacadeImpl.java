package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbs.diagram.application.api.WbsDiagramCommandFacade;
import pl.javorex.pm.wbs.diagram.application.api.command.AddWbsDiagramCmd;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;
import pl.javorex.pm.wbsdiagram.domain.repository.WbsDiagramRepository;

import java.util.Optional;

class WbsDiagramCommandFacadeImpl implements WbsDiagramCommandFacade {
    private final WbsDiagramRepository wbsDiagramRepository;
    private final WbsDiagramFactory wbsDiagramFactory;

    WbsDiagramCommandFacadeImpl(WbsDiagramRepository wbsDiagramRepository) {
        this.wbsDiagramRepository = wbsDiagramRepository;
        this.wbsDiagramFactory = new WbsDiagramFactory();
    }

    @Override
    public void addWbsDiagram(AddWbsDiagramCmd cmd) {
        String projectID = cmd.getProjectId();
        Optional<WbsDiagram> existingProject = wbsDiagramRepository.findWbsDiagramByID(projectID);
        if (existingProject.isPresent()) {
            throw new IllegalStateException("Cannot add project with ID " + projectID + ". Already exists.");
        }

        WbsDiagram newWbsDiagram = wbsDiagramFactory.fromAddProjectCmd(cmd);
        wbsDiagramRepository.save( newWbsDiagram );
    }
}
