package pl.javorex.pm.wbsdiagram.application.response;

public interface WbsDiagramPresentationDto {
    String getProjectId();
    String getName();
    TaskPresentationDto getRootTask();
}
