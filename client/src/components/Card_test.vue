<template>
  <div class="featured__item">
    <div class="featured__item__pic set-bg"
      :style="{backgroundImage: `url(${item.img_Path})`}" >
      <ul class="featured__item__pic__hover">
        <li><a href="#"><i class="fa fa-heart"></i></a></li>

        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
      </ul>
    </div>
    <div class="featured__item__text">
      <h6><a href="#">{{item.name}}</a></h6>
      <h5>{{lib.getNumberFormatted( item.price)}}$$</h5>
    </div>
  </div>


</template>

<script>
import lib from "@/scripts/lib";
import axios from "axios";
export default {
  name: "Card_test",
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
