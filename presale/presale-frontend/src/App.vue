<template>
  <div id="app-container">
    <router-view></router-view>
  </div>
</template>

<script>

import {EventDispatcher} from "@/event/EventDispatcher";

export default {
  name: 'App',
  mounted() {
    const eventDispatcher = EventDispatcher( this.$router );
    eventDispatcher.start();
  }
}
</script>

<style>
</style>
