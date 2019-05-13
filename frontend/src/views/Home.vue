<template>
    <div class="home">

        <div id="section-a">

        </div>

        <div id="section-b">
            <div id="main-text">{{this.mainSectionText}}</div>
            <img alt="vector image of a brain" :src="mainImageSource" id="main-image">

        </div>

        <div id="section-c">
            <h2>Recently Analyzed</h2>

            <hr>
        </div>
        <ul>
            <li v-for="(tweet,index) in tweets" :key="index">
                <div class="tweet-container">
                    <div class="profile-image">

                    </div>
                    <p>{{tweet.text}}</p>
                    <img alt="an emoji to represent sentiment"
                         :src="emojiImage"
                         class="emoji">
                </div>

            </li>

        </ul>
    </div>
</template>

<script>

    export default {
        name: 'home',
        data() {
            return {
                mainSectionText: "Sentiment analysis (also known as opinion mining or emotion AI) refers to the use of " +
                    "natural language processing, text analysis, computational linguistics, and biometrics to " +
                    "systematically identify, extract, quantify, and study affective states and subjective information." +
                    " We empower our users by providing near real-time sentiment analysis, accessible via " +
                    "API or through interactive visualizations.",
                mainImageSource: require("@/assets/brain2colors.svg"),
            }

        },
        methods: {
        },
        computed: {
            tweets() {
                return this.$store.getters.tweets;
            },
            emojiImage(tweet) {
                if (tweet.kind === 'POSITIVE') {
                    return require("@/assets/happy_emoji.svg");
                }
                if (tweet.kind === 'NEGATIVE') {
                    return require("@/assets/sad_emoji.svg");
                } else {
                    return require("@/assets/neutral_emoji.svg");
                }
            },

        }
    }
</script>
<style scoped>
    #main-image {
        width: 20rem;
        height: 20rem;
    }

    #section-a {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #section-b {
        margin-top: 100px;
        display: grid;
        align-content: center;
        justify-content: center;
        grid-template-columns: 1fr 2fr 2fr 2fr 1fr;
        grid-template-rows: auto auto auto;
        grid-gap: 1em;
    }

    #main-text {
        transform: translateY(72px);
        min-width: 20em;
        grid-column: 2/3;
        grid-row: 1/2;
    }

    #main-image {
        grid-column: 4/5;
        grid-row: 1/2;
    }

    .chart {
        grid-column: 2/4;
        grid-row: 2/3;
    }

    hr {
        border: 0;
        border-top: 1px solid #ccc;
    }

    li {
        list-style-type: none;
        text-align: left;
    }

    .tweet-container {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    .emoji {
        width: 32px;
        height: 32px;
        margin-left: auto;
        padding-left: 4px;
    }
</style>
