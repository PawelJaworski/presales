<template>
  <div class="hello">
    <Task :task="rootTask"/>
  </div>
</template>

<script>
import {Task} from "../model/task";

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      rootTask: new Task("dupa")
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
