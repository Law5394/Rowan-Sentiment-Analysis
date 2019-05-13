<template>
    <div id="app">
        <div id="nav-flex-container">
            <div id="nav">
                <router-link to="/" class="nav-link">Rowan Sentiment</router-link>
                <font-awesome-icon :icon="['fab', 'github']" size="lg" id="github-icon"
                                   @click="goToGithub"/>
            </div>

        </div>
        <router-view id="main-router-view"/>
    </div>
</template>
<script>
    export default {
        methods: {
            goToGithub() {
                window.location = 'https://github.com/Law5394/Rowan-Sentiment-Analysis'
            }
        }
    }
</script>
<style>
    @import url('https://fonts.googleapis.com/css?family=Lato');

    html {
        background-color: #676778;
    }

    #app {
        font-family: 'Lato', sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #FFE7FB;
    }

    #main-router-view {
        margin: 0 300px 0 300px;
    }

    #nav {
        padding: 5px;
        display: flex;
        flex-direction: row;
        align-content: center;
        justify-content: flex-end;
    }

    #nav a {
        text-decoration: none;
        font-weight: bold;
        color: #efdeffb3;

    }

    #nav a:hover {
        color: #FFE7FB;
    }

    #nav a.router-link-exact-active {
        text-decoration: underline;
        color: #FFE7FB;
    }

    #nav-flex-container {

    }

    #github-icon {
        margin-left: auto;
        padding-left: 12px;
        padding-top: 8px;
        color: #efdeffb3;
    }

    #github-icon:hover {
        cursor: pointer;
        transform: scale(1.1);
        transform-origin: center;
        color: #FFE7FB;
    }

    .nav-link {
        padding: .5em;
    }
</style>
