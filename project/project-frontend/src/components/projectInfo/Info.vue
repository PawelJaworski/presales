<template>
  <div class="hello">
    <h1>Info of {{ id }}</h1>
  </div>
</template>

<script>
export default {
  name: 'ProjectInfo',
  props: {
    id: String,
    server_context: String,
    containerId: {
      type: String,
      default:  "app-container"
    }
  },
  mounted() {
    const that = this;
    document.getElementById(this.containerId).addEventListener("PROJECT_SELECTED", function (e) {
      that.loadProjectInfo(e.detail);
    });
  },
  methods: {
    loadProjectInfo(info) {
      this.info = "Project Info Updated: " + info
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
