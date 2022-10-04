<template>
    <div class="cart">
        <div class="container">
            <ul>
                <li v-for="(i, idx) in state.items" :key="idx">
                    <img :src="i.img_Path"/>
                    <span class="name">{{i.name}}</span>
                    <span class="price">{{i.price}}</span>
                    <button class = btn>
                        <i class="fa fa-info-circle" aria-hidden="true"></i>
                    </button>
                </li>
            </ul>
        </div>
    </div>
</template>


<script>
import { reactive } from "vue";
import axios from 'axios';

export default {
    setup() {
        const state = reactive({
            items:[]
        })


        axios.get("/api/cart/items").then(({data}) => {
            console.log(data);
            state.items = data;
        })

        return { state }
    }
}
</script>

<style scoped>
ul{
    list-style: none;
    margin:0;
    padding:0;
}

li{
    boder:10px solid #eee;
    margin-top : 25px;
    margin-bottom: 25px;
}


img{
    width:100px;
    height:100px;
}

.cart ul li .name{
    margin-left: 25px;
}
.cart ul li .price{
    margin-left: 25px;
}
.cart ul li .btn{
    margin-left: 25px;
}
</style>