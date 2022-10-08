<template>
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
</template>


<script>
import axios from "axios";
import { reactive } from "vue";
import Card_test from "@/components/Card_test.vue";
export default {
  name: "Home",
  components: { Card_test },
  setup() {
    const state = reactive({
      items: []
    })

    axios.get("/api/items").then(({ data }) => {
      state.items = data;
    })

    return { state }
  }
}
</script>


<style scoped>
@import '@/assets/css/bootstrap.min.css';
@import '@/assets/css/style.css';
@import '@/assets/css/owl.carousel.min.css';


</style>