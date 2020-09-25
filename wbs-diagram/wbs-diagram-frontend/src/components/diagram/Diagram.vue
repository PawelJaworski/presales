<template>
<div>
  <ul v-if="this.rootTask" class="tree">
    <Task :task="this.rootTask"/>
  </ul>
</div>
</template>

<script>
import Vue from 'vue'
import Task from "./Task";
import axios from 'axios'
import VueAxios from 'vue-axios'

axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost*';

Vue.use(VueAxios, axios)

export default {
  name: "Diagram",
  components: {Task},
  props: {
    server_context: String
  },
  mounted() {
    this.loadProjects();
  },
  data() {
    return {
      rootTask: undefined
    }
  },
  methods: {
    loadProjects() {
      const that = this;
      this.$http.get(`${this.server_context}/wbsDiagrams/1`)
          .then((res) => {
            that.rootTask = res.data.rootTask;
          })
    }
  }
}
</script>

<style src="@/assets/css/diagram.css">
</style>
