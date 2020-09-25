<template>
      <li>
        <span>
          <h3>{{ task.name }}</h3>
          <div><u>{{ categories }}</u></div><br/>
          <div><i>Estimation: </i><b>{{task.estimation}}</b></div>
        </span>
        <ul v-if="task.children && task.children.length > 0">
          <Task v-for="child in task.children" v-bind:key="child.id" :task="child"/>
        </ul>
      </li>
</template>

<script>
export default {
  name: "Task",
  props: {
    task: Object
  },
  computed: {
    categories() {
      if (this.task.categories && this.task.categories.length > 0) {
        return `(${this.task.categories.join(', ')})`;
      }

      return undefined;
    }
  },
}
</script>


