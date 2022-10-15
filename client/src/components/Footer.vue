<template>
  <div class="flex w-11/12 h-16 items-center justify-around m-auto" id ="hello">
    <div class="w-3/12 md:flex items-center hidden"><img class="w-20 h-20 rounded-full"
        src="../../public/img/img1.jpeg">
      <div class="flex flex-col ml-5 font-semibold text-white">
        <p>Dangerously</p>
        <p class="text-xs text-white">Charlie Puth</p>
      </div>
    </div>
    <div class="w-4/5 flex md:w-8/12 items-center">
      <div class="text-sm text-white w-2/12 md:w-1/12 font-semibold">
        <p>00:00</p>
      </div>
      <div class="mt-1 relative w-8/12 md:w-10/12">
        <div class="h-1 bg-grey-dark cursor-pointer rounded-full bg-gray-500">
          <div class="flex w-full justify-end h-1 bg-gradient-to-r from-blue-500 to-blue-700 rounded-full relative"
            style="width: 0.412101%;"></div>
        </div>
        <div class="flex w-full justify-end h-1 rounded-full relative" style="width: 0.412101%;"><span
            id="progressButtonTimer"
            class="w-3 h-3 md:w-4 md:h-4 bg-gradient-to-r from-blue-500 to-blue-700 absolute pin-r pin-b -mb-1 rounded-full shadow"></span>
        </div>
      </div>
      <div class="text-sm text-white w-2/12 md:w-1/12 font-semibold">
        <p>03:13</p>
      </div>
    </div>
    <div class="w-1/5 flex md:w-2/12 m-auto items-center">
      <div class="w-3/12 md:w-2/12 hover:bg-gray-500 rounded-full md:p-1"><svg class="w-6 h-6 m-auto cursor-pointer"
          xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M15.536 8.464a5 5 0 010 7.072m2.828-9.9a9 9 0 010 12.728M5.586 15H4a1 1 0 01-1-1v-4a1 1 0 011-1h1.586l4.707-4.707C10.923 3.663 12 4.109 12 5v14c0 .891-1.077 1.337-1.707.707L5.586 15z">
          </path>
        </svg></div>
      <div class="w-9/12 md:w-6/12 m-auto relative">
        <div class="h-1 bg-grey-dark cursor-pointer rounded-full bg-gray-500 m-auto relative" style="width: 100%;">
          <div class="flex justify-end h-1 bg-gradient-to-r from-teal-400 to-blue-500 rounded-full relative"
            style="width: 70%;"></div>
        </div>
        <div class="flex justify-end h-1 rounded-full relative" style="width: 70%;"><span id="progressButtonVolume"
            class="w-3 h-3 md:w-4 md:h-4 bg-gradient-to-r from-teal-400 to-blue-500 absolute pin-r pin-b -mb-1 rounded-full shadow"></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Footer',

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
  top: 50%;
  left: 50%;
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
