export class TaskModel {
    id;
    name;
    children;
    constructor(id, name, children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

}
