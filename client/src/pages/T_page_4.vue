<template>


  <div class="album py-5 bg-dark">
    <div class="col-12">
      <div class="section-title" id="sel">
        <h2>Daily Music</h2>
      </div>
    </div>
    <carousel-3d :controls-visible="true" :clickable="false" :height="300">
      <slide :index="i" :key="i" v-for="(slide, i) in slides">
        <figure>
          <img :src="slide.src" />
          <figcaption>
            <v-btn text color="white">{{slide.text}}</v-btn>
          </figcaption>
        </figure>
      </slide>
    </carousel-3d>
  </div>
</template>

<script>
import { Carousel3d, Slide } from 'vue3-carousel-3d';
export default {
  data: () => ({
    slides: [
      { src: require('../../public/01.jpg'), text: 'Cheb Khaled' },
      { src: require('../../public/img/고양2.jpg'), text: 'Cheb Khaled' },
      { src: require('../../public/img/곰.jpg'), text: 'Cheb Khaled' },
      { src: require('../../public/01.jpg'), text: 'Cheb Khaled' },
      { src: require('../../public/01.jpg'), text: 'Cheb Khaled' },
    ]
  }),

  components: {
    Carousel3d,
    Slide
  },
};


</script>



<style scoped>
.carousel-3d-container figure {
  margin: 0;
}

.carousel-3d-container figcaption {
  position: absolute;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  bottom: 0;
  position: absolute;
  bottom: 0;
  padding: 15px;
  font-size: 12px;
  min-width: 100%;
  box-sizing: border-box;
}

#sel{
  background :darkkhaki
}
</style>