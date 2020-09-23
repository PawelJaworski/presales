<template>
      <li>
        <span>{{task.name}}</span>
        <ul v-if="task.children">
          <Task v-for="child in task.children" v-bind:key="child.id" :task="child"/>
        </ul>
      </li>
</template>

<script>
import {TaskModel} from "../../model/task";

export default {
  name: "Task",
  props: {
    task: TaskModel
  }
}
</script>


