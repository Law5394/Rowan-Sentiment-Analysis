import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faGithub} from '@fortawesome/free-brands-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import VueApexCharts from 'vue-apexcharts'
import axios from "axios";

library.add(faGithub)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.component('apexchart', VueApexCharts)

Vue.config.productionTip = false


axios.get('https://api.rowansentiment.com/tweets')
    .then(res => {
        store.commit('setTweets', {tweets: res.data});
        new Vue({
            router,
            store,
            render: h => h(App)
        }).$mount('#app');
    });
