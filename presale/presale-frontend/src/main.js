import Vue from 'vue'
import App from './App.vue'
import ProjectListPage from '@/components/ProjectListPage';

Vue.config.productionTip = false
import VueRouter from 'vue-router'

Vue.use(VueRouter)
const routes = [
  { path: '/', component: ProjectListPage }
]

// 3. Create the router instance and pass the `routes` option
// You can pass in additional options here, but let's
// keep it simple for now.
const router = new VueRouter({
  routes // short for `routes: routes`
})
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

