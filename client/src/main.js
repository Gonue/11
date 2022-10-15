import { createApp } from "vue";
import store from "@/scripts/store"
import router from "@/scripts/router"
import App from "./App.vue";
import Carousel3d from 'vue3-carousel-3d';
import "vue3-carousel-3d/dist/index.css"
import VueAudio from 'vue-audio-better'

import Vue3VideoPlayer from '@cloudgeek/vue3-video-player'
import '@cloudgeek/vue3-video-player/dist/vue3-video-player.css'


import '@/assets/css/style.css';

createApp(App).use(store).use(router).use(Carousel3d).use(Vue3VideoPlayer, {lang: 'en'})
.use(VueAudio).mount("#app");
