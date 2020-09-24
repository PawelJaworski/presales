package pl.javorex.pm.wbsdiagram.application.api;

import pl.javorex.pm.wbsdiagram.application.command.AddWbsDiagramCmd;

public interface WbsDiagramCommandFacade {
    void addWbsDiagram(AddWbsDiagramCmd cmd);
}
