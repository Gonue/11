import { createApp } from "vue";
import store from "@/scripts/store"
import router from "@/scripts/router"
import App from "./App.vue";

import Vue3VideoPlayer from '@cloudgeek/vue3-video-player'
import '@cloudgeek/vue3-video-player/dist/vue3-video-player.css'

createApp(App).use(store).use(router).use(Vue3VideoPlayer, {lang: 'en'}).mount("#app");
