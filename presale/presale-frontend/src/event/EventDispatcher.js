const PROJECT_LIST = "ProjectList";
const APP_CONTAINER_ID = "app-container";
export const EventDispatcher = function($router) {
    let $container;

    function onProjectSelected(detail) {
        $router.push({ path: `/projectInfo/${detail.projectID}` })
    }

    function start() {
        $container = document.getElementById(APP_CONTAINER_ID);
        $container.addEventListener(`${PROJECT_LIST}.PROJECT_SELECTED`, function (e) {
            onProjectSelected(e.detail);
        });
    }
    return {
        start: start
    }
}
