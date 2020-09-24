<template>
<div>
  <ul class="tree">
    <Task :task="rootTask"/>
  </ul>
</div>
</template>

<script>
import {TaskModel} from "../../model/task";
import Task from "./Task";

export default {
  name: "Diagram",
  components: {Task},
  methods: {
    rightClick() {
      alert("dupa")
    }
  },
  mounted() {
    this.loadProjects();
  },
  data() {
    return {
      rootTask: new TaskModel(1, "dupa", [new TaskModel(2, "dupa2"), new TaskModel(3, "dupa3")])
    }
  }
}
</script>

<style src="@/assets/css/diagram.css">
</style>
