<template>
  <div>
    {{$route.params.projectID}}
  <project-info server_context="http://localhost:8001" :id="$route.params.projectID"></project-info>
  </div>
</template>

<script>
export default {
  name: "ProjectInfoPage"
}
</script>

<style scoped>

</style>
