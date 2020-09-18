<template>
  <div id="app">
    <Diagram/>
  </div>
</template>

<script>
import Diagram from "./components/diagram/Diagram";

export default {
  name: 'App',
  components: {
    Diagram
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
