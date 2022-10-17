<template>

    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center py-2">
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="h5 mb-4 text-center py-3">Cart</h3>
                        <div class="table-wrap">
                            <table class="table">
                                <thead class="thead-primary">
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>Product</th>
                                        <th>Product_Name</th>
                                        <th>Writer</th>
                                        <th>Price</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="alert" role="alert" v-for="(i, idx) in state.items_Cart" :key="idx">
                                        <td class="border-bottom-0">
                                            <label class="checkbox-wrap checkbox-primary">
                                                <input type="checkbox" class="align-items-center : container">
                                                <span class="checkmark"></span>
                                            </label>
                                        </td>
                                        <td class="border-bottom-0">
                                            <img :src="i.img_Path" />
                                        </td>
                                        <td class="border-bottom-0 ">
                                            <div class="email">
                                                <span>{{i.name}}</span>
                                            </div>
                                        </td>
                                        <td class="border-bottom-0">{{i.write}}</td>

                                        <td class="border-bottom-0">{{i.price}}</td>
                                        <td class="border-bottom-0">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">
                                                    <i class="fa fa-close" @click="remove(i.id)"></i>
                                                </span>
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="container py-3">
                    <router-link to="/order" class="col-12 btn btn-primary btn3">구입하기</router-link>
                </div>
                <p class="py-5" />
            </div>
        </section>
    </body>

</template>


<script>
import { reactive } from "vue";
import axios from 'axios';

export default {
    setup() {
        const state = reactive({
            items_Cart: []

        })
        const load = () => {
            axios.get("/api/cart/items").then(({ data }) => {
                state.items_Cart = data;
                console.log("cart" + data);
            })
        };
        const remove = (itemId) => {
            axios.delete(`/api/cart/items/${itemId}`).then(() => {
                load();
            })
        }
        load();
        return { state, remove }
    }
}
</script>


<style scoped>
img {
    width: 100px;
    height: 100px;
}

.table tbody th,
.table tbody td {
    border: none;
    padding: 30px;
    font-size: 12px;
    background: #fff;
    border-bottom: 4px solid #f8f9fd;
    vertical-align: middle;
}

.table thead th {
    border: none;
    padding: 30px;
    font-size: 13px;
    font-weight: 500;
}

.btn3 {
    width: 200px;
    display: block;
    margin: 0 auto;
    padding: 30px 50px
}
</style>
