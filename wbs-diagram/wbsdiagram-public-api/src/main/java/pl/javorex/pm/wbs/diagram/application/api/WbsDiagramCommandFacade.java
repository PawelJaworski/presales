package pl.javorex.pm.wbs.diagram.application.api;

import pl.javorex.pm.wbs.diagram.application.api.command.AddWbsDiagramCmd;

public interface WbsDiagramCommandFacade {
    void addWbsDiagram(AddWbsDiagramCmd cmd);
}
