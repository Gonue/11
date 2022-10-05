<template>
  <div class="card bg-dark shadow-sm text-white">
    <router-link to="/detail">
    <span class="img" :style="{backgroundImage: `url(${item.img_Path})`}" />
  </router-link>
    <div class="card-body">
      <p class="card-text">{{item.name}}</p>
      <div class="d-flex justify-content-between align-items-center">
        <div class="btn-group">
          <button class="btn btn-dark btn1" @click="addToCart(item.id)">
            <i class="fa fa-heart" aria-hidden="true"></i>
          </button>
          <button class="btn btn-dark btn2">
            <router-link to="/Chat"><i class="fa fa-commenting" aria-hidden="true"></i></router-link>
          </button>
        </div>
        <small class="text-muted">
          {{lib.getNumberFormatted( item.price)}}$$
        </small>
        <!-- <small class="discount text-denger text-muted">
          {{item.discount_Per}}%
        </small> -->

      </div>
    </div>
  </div>
</template>

<script>
import lib from "@/scripts/lib";
import axios from "axios";
export default {
  name: "Card",
  props: {
    item: Object
  },
  setup() {
    const addToCart = (itemId) => {
      axios.post(`/api/cart/items/${itemId}`).then(() => {
        console.log('success')
      })
    };
    return { lib, addToCart }
  }
}
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 300px;
  background-size: cover;
  background-position: center;
}

.btn1 {
  color: red;
}

.btn2 {
  color: yellow;
}
</style>
