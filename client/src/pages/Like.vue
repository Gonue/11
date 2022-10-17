<template>
    좋아용
    <div class="cart py-3">
        <div class="container">
            <ul>
                <li v-for="(i, idx) in state.items_Like" :key="idx">
                    <img :src="i.img_Path" />
                    <span class="name">{{i.name}}</span>
                    <span class="price">{{i.price}}</span>

                    <button class=btn>
                        <i class="fa fa-info-circle" aria-hidden="true"></i>
                    </button>

                    <button class=btn1>
                        <i class="fa fa-times" aria-hidden="true" @click="remove(i.id)"></i>
                    </button>
                </li>
                
            </ul>
                <router-link to="/order" class="btn btn-primary btn3">구입하기</router-link>
        </div>
    </div>
</template>


<script>
import { reactive } from "vue";
import axios from 'axios';

export default {
    setup() {
        const state = reactive({
            items_Like: []
        })
        const load = () => {
            axios.get("/api/like/items").then(({ data }) => {
                console.log("like"+data);
                state.items_Like = data;
                console.log("like"+ data)
            })
        };
        const remove = (itemId) => {
            axios.delete(`/api/like/items/${itemId}`).then(() => {
                load();
            })
        }
        load();
        return { state, remove }
    }
}
</script>

<style scoped>
.cart ul {
    list-style: none;
    margin: 0;
    padding: 0;
}

.cart ul li {
    border: 10px solid #eee;
    margin-top: 25px;
    margin-bottom: 25px;
}


img {
    width: 200px;
    height: 200px;
}

.cart ul li .name {
    margin-left: 200px;
}

.cart ul li .price {
    margin-left: 25px;
}

.cart ul li .btn {
    margin-left: 25px;
}

.cart ul li .btn1 {
    float: right;
    font-size: 20px;
    margin-top: 10px;
    margin-right: 30px;
}
.cart .btn3{
    width :200px;
    display: block;
    margin:0 auto;
    padding: 30px 50px
}

</style>