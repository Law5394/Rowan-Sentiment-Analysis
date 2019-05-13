import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        tweets: null,
    },
    getters: {
        tweets(state) {
            return state.tweets.splice(0,10);
        },
    },
    mutations: {
        setTweets(state, payload) {
            state.tweets = payload.tweets;
        },
    },
    actions: {

    }
})
