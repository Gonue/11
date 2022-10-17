<template>
  
  <div class="flex w-11/12 h-16 items-center justify-around m-auto" id="hello">
    <div class="w-4/12 md:flex items-center hidden"
    v-for="(audio, indexo) in audios.slice(index, index + 1)" :key="indexo">  
      <img class="w-20 h-20 rounded-full" :src="audio.src">
      <div class="flex-col ml-5 font-semibold text-white">
        <p>{{ audio.name }}</p>
        <p class="text-xs text-white">{{ audio.artist }}</p>
      </div>
      

      <div class="text-grey-darker hover:bg-gray-300 rounded-full ml-5">
            <svg
              @click="prevButton ? previous() : ''"
              class="w-8 h-8 cursor-pointer"
              fill="currentColor"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 20 20"
            >
              <path d="M4 5h3v10H4V5zm12 0v10l-9-5 9-5z" />
            </svg>
          </div>
      <!-- start-->
      <div class="text-grey-darker p-3 rounded-full">
        
        <svg v-if="!pauseTrack" @click="play()" class="w-8 h-8 cursor-pointer" xmlns="http://www.w3.org/2000/svg"
          fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M14.752 11.168l-3.197-2.132A1 1 0 0010 9.87v4.263a1 1 0 001.555.832l3.197-2.132a1 1 0 000-1.664z" />
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
        </svg>
        <svg v-else @click="pause()" class="w-8 h-8 cursor-pointer" fill="currentColor"
          xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
          <path d="M5 4h3v12H5V4zm7 0h3v12h-3V4z" />
        </svg>
      </div>

      <div class="text-grey-darker hover:bg-gray-300 rounded-full p-1">
            <svg
              @click="nextButton ? next() : ''"
              class="w-8 h-8 cursor-pointer"
              fill="currentColor"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 20 20"
            >
              <path d="M13 5h3v10h-3V5zM4 5l9 5-9 5V5z" />
            </svg>
          </div>
    </div>


    <!---->
    
    <div class="w-3/5 flex md:w-6/12 items-center">
      <div class="text-sm text-white w-3/12 md:w-1/12 font-semibold">
        <p>{{ timer }}</p>
      </div>
      <div class="mt-1 relative w-8/12 md:w-10/12">
        <div @click="seek($event)" ref="progress"
        class="h-1 bg-grey-dark cursor-pointer rounded-full bg-white">
          <div class="flex w-full justify-end h-1 bg-gradient-to-r from-gray-500 to-gray-700 rounded-full relative"
            :style="{width: step +'%'}"></div>
        </div>
        <div class="flex w-full justify-end h-1 rounded-full relative" :style="{ width: step + '%' }"><span
            id="progressButtonTimer"
            class="w-3 h-3 md:w-4 md:h-4 bg-gradient-to-r from-blue-100 to-blue-100 absolute pin-r pin-b -mb-1 rounded-full shadow"></span>
        </div>
      </div>
      <div class="text-sm text-white w-2/12 md:w-1/12 font-semibold">
        <p>{{ duration }}</p>
      </div>
    </div>
    <div class="w-1/5 flex md:w-2/12  items-center">
      <div class="w-3/12 md:w-2/12 hover:bg-gray-500 rounded-full md:p-1" @click="mute()">
        <svg v-if="mutePlayer" class="w-6 h-6 m-auto cursor-pointer"
          xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M15.536 8.464a5 5 0 010 7.072m2.828-9.9a9 9 0 010 12.728M5.586 15H4a1 1 0 01-1-1v-4a1 1 0 011-1h1.586l4.707-4.707C10.923 3.663 12 4.109 12 5v14c0 .891-1.077 1.337-1.707.707L5.586 15z" clip-rule="evenodd">
          </path>
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M17 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2" ></path>
        </svg>
        <svg v-else class="w-6 h-6 m-auto cursor-pointer" xmlns="http://www.w3.org/2000/svg" fill="none"
                            viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M15.536 8.464a5 5 0 010 7.072m2.828-9.9a9 9 0 010 12.728M5.586 15H4a1 1 0 01-1-1v-4a1 1 0 011-1h1.586l4.707-4.707C10.923 3.663 12 4.109 12 5v14c0 .891-1.077 1.337-1.707.707L5.586 15z" />
                        </svg>
      </div>
      <div class="w-9/12 md:w-6/12 m-auto relative">
        <div @click="volume($event)" ref="volBar" class="h-1 bg-white cursor-pointer rounded-full bg-gray-500 m-auto relative" style="width: 100%;">
          <div class="flex justify-end h-1 bg-gradient-to-r from-gray-400 to-gray-500 rounded-full relative"
          :style="{ width: volumeProgress + '%' }"></div>
        </div>
        <div class="flex justify-end h-1 rounded-full relative" :style="{ width: volumeProgress + '%' }"><span id="progressButtonVolume"
            class="w-3 h-3 md:w-4 md:h-4 bg-white absolute pin-r pin-b -mb-1 rounded-full shadow"></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, reactive } from "vue"
import A1 from "@/music/A1.mp3"
import A2 from "@/music/A2.mp3"
import A3 from "@/music/A3.mp3"
import Dangerously from "@/music/Dangerously.mp3"
import Destination from "@/music/Destination.mp3"
import Sunroof from "@/music/Sunroof.mp3"


import { Howl, Howler } from "howler"

export default {
  name: 'Footer',
  
  setup() {
        const audios = ref([
            { name: "null", artist:"null", howl:null, src: require('../../public/img/black.jpeg')},
            { name: "Dangerously", file: Dangerously, artist: "Charlie Puth", howl: null, src: require('../../public/img/img1.jpeg') },
            { name: "Sunroof", file: Sunroof, artist: "Nicky Youre", howl: null, src: require('../../public/img/img2.jpeg')},
            { name: "Destination", file: Destination, artist: "Crash adams", howl: null, src: require('../../public/img/img3.jpeg') },
        ])
        const step = ref(0)
        const nextButton = ref(true)
        const prevButton = ref(true)
        const random = ref(false)
        const repeat = ref(false)
        const index = ref(0)
        const duration = ref("00:00")
        const timer = ref("00:00")
        const pauseTrack = ref(false)
        const progress = ref(null)
        const volBar = ref(null)
        const sliderBtn = ref(0)
        const sliderBtnVol = ref(null)
        const volumeProgress = ref(50)
        const mutePlayer = ref(false)
        const state = reactive({
            audioPlaying: [],
        })
        function formatTime(secs) {
            var minutes = Math.floor(secs / 60) || 0
            var seconds = Math.floor(secs - minutes * 60) || 0

            return (
                (minutes < 10 ? "0" : "") +
                minutes +
                ":" +
                (seconds < 10 ? "0" : "") +
                seconds
            )
        }
        function play() {
            var sound

            var audio = audios.value[index.value]
            if (audio.howl) {
                sound = audio.howl
            } else {
                state.audioPlaying[index.value] = false
                sound = audio.howl = new Howl({
                    src: [audio.file],
                    html5: true, // A live stream can only be played through HTML5 Audio.
                    format: ["mp3", "aac"],
                    onplay: function () {
                        pauseTrack.value = true
                        nextButton.value = true
                        prevButton.value = true
                        duration.value = formatTime(sound.duration())
                        requestAnimationFrame(stepFunction.bind(this))
                    },
                    onpause: function () {
                        pauseTrack.value = false
                    },
                    onend: function () {
                        next()
                    },
                    onseek: function () {
                        window.requestAnimationFrame(stepFunction.bind(this))
                    },
                })
            }

            sound.play()

            state.audioPlaying[index.value] = true
        }
        function pause(indexo) {
            var audio = audios.value[index.value].howl

            if (audio) {
                audio.pause()
                pauseTrack.value = false
                state.audioPlaying[index.value] = false
            }
        }

        function stepFunction() {
            var sound = audios.value[index.value].howl
            var seek = sound.seek()
            timer.value = formatTime(Math.round(seek))
            step.value = (seek * 100) / sound.duration()

            sliderBtn.value =
                progress.value.offsetWidth * (step.value / 100) +
                progress.value.offsetWidth * 0.05 -
                25

            if (sound.playing()) {
                window.requestAnimationFrame(stepFunction.bind(this))
            }
        }

        function seek(event) {
            var per = event.offsetX / progress.value.clientWidth

            var sound = audios.value[index.value].howl

            if (sound) {
                if (sound.playing()) {
                    sound.pause()
                    sound.seek(sound.duration() * per)
                    var barWidth = (per * 100) / 100
                    sliderBtn.value =
                        progress.value.offsetWidth * barWidth +
                        progress.value.offsetWidth * 0.05 -
                        25
                    sound.play()
                } else {
                    sound.seek(sound.duration() * per)
                    var barWidth = (per * 100) / 100
                    sliderBtn.value =
                        progress.value.offsetWidth * barWidth +
                        progress.value.offsetWidth * 0.05 -
                        25
                }
            }
        }

        function next() {
            nextButton.value = false
            var audio = audios.value[index.value].howl

            state.audioPlaying[index.value] = false

            mutePlayer.value ? (mutePlayer.value = false) : ""
            audio && audio.mute(true) ? audio.mute(false) : ""

            if (audio && audios.value.length - 1 == index.value) {
                audio.stop()

                repeat.value
                    ? (index.value = index.value)
                    : random.value
                        ? (index.value = Math.floor(Math.random() * audios.value.length))
                        : (index.value = 0)
            } else {
                if (audio) {
                    audio.stop()
                }

                repeat.value
                    ? (index.value = index.value)
                    : random.value
                        ? (index.value = Math.floor(Math.random() * audios.value.length))
                        : index.value++
            }

            play()
        }

        function previous() {
            var audio = audios.value[index.value].howl
            prevButton.value = false
            state.audioPlaying[index.value] = false

            mutePlayer.value ? (mutePlayer.value = false) : ""
            audio && audio.mute(true) ? audio.mute(false) : ""

            if (!audio) {
                index.value = audios.value.length - 1
            } else if (audio && index.value == 0) {
                audio.stop()

                repeat.value
                    ? (index.value = index.value)
                    : random.value
                        ? (index.value = Math.floor(Math.random() * audios.value.length))
                        : (index.value = audios.value.length - 1)
            } else if (audio) {
                audio.stop()

                repeat.value
                    ? (index.value = index.value)
                    : random.value
                        ? (index.value = Math.floor(Math.random() * audios.value.length))
                        : index.value--
            }

            play()
        }
        function selectSound(indexSelected) {
            var audio = audios.value[index.value].howl

            if (audio) {
                audio.stop()
                state.audioPlaying[index.value] = false
            }

            index.value = indexSelected

            play()
        }

        function volume(event) {
            var per = event.layerX / parseFloat(volBar.value.scrollWidth)
            var barWidth = (per * 100) / 100
            volumeProgress.value = barWidth * 100
            sliderBtnVol.value =
                volBar.value.offsetWidth * barWidth +
                volBar.value.offsetWidth * 0.05 -
                25
            Howler.volume(per)
        }

        function mute() {
            var audio = audios.value[index.value].howl

            if (audio) {
                mutePlayer.value = !mutePlayer.value

                mutePlayer.value ? audio.mute(true) : audio.mute(false)
            }
        }

        return {
            play,
            pause,
            duration,
            formatTime,
            audios,
            pauseTrack,
            next,
            previous,
            index,
            timer,
            step,
            stepFunction,
            seek,
            selectSound,
            state,
            random,
            repeat,
            progress,
            volume,
            volBar,
            volumeProgress,
            sliderBtn,
            mute,
            mutePlayer,
            sliderBtnVol,
            nextButton,
            prevButton,
        }
    },
}


</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

* {
  font-family: "Poppins", sans-serif;
}

#journal-scroll::-webkit-scrollbar {
  width: 0.9rem;
  cursor: pointer;
}

#journal-scroll::-webkit-scrollbar-track {
  background-color: #ffffff;
  cursor: pointer;
}

#journal-scroll::-webkit-scrollbar-thumb {
  cursor: pointer;
  border-radius: 10px;
  background-color: #4096de;
  border: 3px solid #ffffff;
}

.cd-center {
  position: absolute;
  top: 70%;
  left: 70%;
  transform: translate(-50%, -50%);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background-color: #f7fafc;
}

#progressButtonTimer,
#progressButtonVolume {
  margin-top: -9px;
  right: -8px;
}

@media screen and (max-width: 768px) {

  #progressButtonTimer,
  #progressButtonVolume {
    margin-top: -8px;
    right: -7px;
  }
}
</style>
