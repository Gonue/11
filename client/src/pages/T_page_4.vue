<template>


  <div class="album py-5 bg-dark">
    <div class="col-12">
      <div class="section-title" id="sel">
        <h2>Artist of the Week</h2>
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

    <div class="col-12 text-center">
      <button type="button" class="btn btn-primary m-1">Primary</button>
      <button type="button" class="btn btn-secondary m-1">Secondary</button>
      <button type="button" class="btn btn-success m-1">Success</button>
      <button type="button" class="btn btn-secondary m-1">Secondary</button>
    </div>

    <section class="featured spad">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="section-title">
                <h2>Featured Product</h2>
              </div>
            </div>
          </div>
          <div class="row featured__filter">
            <!-- <div class="col-lg-3 col-md-4 col-sm-6 "> -->
            <div class="row row-cols-1  row-cols-sm-2 row-cols-md-4 g-3">
              <div class="col" v-for="(item, idx) in state.items" :key="idx">
                <Card_test :item="item" />
              </div>
            </div>
          </div>
        </div>
      </section>



    
  </div>
</template>

<script>
import { Carousel3d, Slide } from 'vue3-carousel-3d';
import axios from "axios";
import { reactive } from "vue";
import Card_test from "@/components/Card_test.vue";
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
    Slide,
    Card_test
  },
  setup() {
    const state = reactive({
      items: []
    })

    axios.get("/api/items").then(({ data }) => {
      state.items = data;
    })
    return { state }
  }
};


</script>



<style scoped>
@import '@/assets/css/bootstrap.min.css';
@import '@/assets/css/style.css';
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
  padding: 20px;
  font-size: 20px;
  min-width: 100%;
  box-sizing: border-box;
}

#sel {
  background: darkkhaki
}

::v-deep .prev {
  color: beige !important;
}

::v-deep .next {
  color: beige !important;
}
</style>