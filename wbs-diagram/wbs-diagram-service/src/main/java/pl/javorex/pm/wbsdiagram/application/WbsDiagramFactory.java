package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbsdiagram.application.command.AddWbsDiagramCmd;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;

final class WbsDiagramFactory {
    WbsDiagram fromAddProjectCmd(AddWbsDiagramCmd cmd) {
        return new WbsDiagram( cmd.getProjectId(), cmd.getName()  );
    }
}
