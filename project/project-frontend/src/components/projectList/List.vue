<template>
  <div class="container">
    <div class="page-header">
      <h1>Bootstrap Tutorial</h1>
      <h1>Project List</h1>
    </div>
    <div class="alert alert-success">
      <strong>Success!</strong> Indicates a successful or positive action.
    </div>
    <div class="overflow-auto">
      <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="my-table"
      ></b-pagination>

      <p class="mt-3">Current Page: {{ currentPage }}</p>

      <b-table
          id="project-list-table"
          :fields="fields"
          :items="items"
          :per-page="perPage"
          :current-page="currentPage"
          @row-selected="onSelect"
          small
          selectable
          select-mode="single"
      ></b-table>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import {BootstrapVue} from "bootstrap-vue"

axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost*';

Vue.use(BootstrapVue)
Vue.use(VueAxios, axios)


export default {
  name: 'ProjectList',
  props: {
    server_context: String,
    containerId: {
      type: String,
      default:  "app-container"
    }
  },
  data() {
    const projects = []
    return {
      perPage: 3,
      currentPage: 1,
      items: projects,
      fields: [
            { key: 'id',  thClass: 'd-none', tdClass: 'd-none' },
            { key: 'name', sortable: 'true' },
            { key: 'description', sortable: 'true' }
        ]
    }
  },
  computed: {
    rows() {
      return this.items.length
    }
  },
  methods: {
    onSelect(items) {
      console.log(`items.id ${items[0].id}`)
      const projectID = items[0].id;
      this.dispatchEvent( 'PROJECT_SELECTED', { projectID: projectID } );

      console.log("Selected:")

      console.log(JSON.stringify(items))
    },
    loadProjects() {
      const that = this;
      this.$http.get(`${this.server_context}/projects`).then((res) => {
        that.items = res.data;
      })
    },
    dispatchEvent(name, detail = {}) {
      const eventName = `ProjectList.${name}`;
      console.log(`Dispatching event ${eventName}`)
      document.getElementById(this.containerId)
          .dispatchEvent(new CustomEvent(eventName, {detail}))
    }
  },
  mounted() {
    this.loadProjects()
  }
}
</script>
<style lang="scss">
  @import '~bootstrap';
  @import '~bootstrap-vue';
</style>
