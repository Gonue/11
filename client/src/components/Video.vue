<template>

  


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
