<template>
  <div class="featured__item">
    <div class="featured__item__pic set-bg" :style="{backgroundImage: `url(${item.img_Path})`}">
      <ul class="featured__item__pic__hover">

        <li>
          <a @click="play('http://soundbible.com/mp3/Air Plane Ding-SoundBible.com-496729130.mp3')">
            <i class="fa fa-play" aria-hidden="true"></i>
          </a>
        </li>

        <li>
          <a @click="addToCart(item.id), submit1()">
            <i class="fa fa-heart">
            </i>
          </a>
        </li>

        <li>
          <a @click="addToLike(item.id), submit()">
            <i class="fa fa-shopping-cart">
            </i>
          </a>
        </li>

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
import { reactive } from '@vue/reactivity';
export default {
  name: "Card_test",
  props: {
    item: Object
    
  },

  methods:{
    play(sound) {
      if (sound) {
        var audio = new Audio(sound);
        audio.play();
      }
    }
  },
  setup() {
    
    const addToCart = (itemId) => {
      axios.post(`/api/cart/items/${itemId}`).then(() => {
        console.log('cart success')
      })
    };

    const addToLike = (itemId) => {
      axios.post(`/api/like/items/${itemId}`).then(() => {
        console.log('like success')
      })
    };
    const submit = () => {
                window.alert(" 장바구니추가!");
            }
    const submit1 = () => {
      window.alert("좋아용🤡");
    }
    

    return { lib, addToCart, addToLike, submit, submit1}
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
